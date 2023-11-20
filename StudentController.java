package com.example.mvccrud.ctms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mvccrud.ctms.DTO.StudentDTO; // Updated import for StudentDTO
import com.example.mvccrud.ctms.DTO.StudentLoginDto; // Updated import for StudentLoginDto
import com.example.mvccrud.ctms.model.Student; // Updated import for Student
import com.example.mvccrud.ctms.repo.StudentRepo; // Updated import for StudentRepo

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo sr; // Updated repository for Student

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody StudentDTO sd) {
        // Check if a user with the provided email already exists
        if (sr.existsByEmail(sd.getId())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        // Create a new Student object and set its properties
        Student newStudent = new Student();
        newStudent.setUsername(sd.getUsername());
        newStudent.setPassword(sd.getPassword());
        newStudent.setEmail(sd.getId());
        newStudent.setPhone(sd.getPhone());
        newStudent.setBranch(sd.getBranch());
        newStudent.setAddress(sd.getAddress());
        newStudent.setSelectroute(sd.getSelectroute());
        newStudent.setGender(sd.getGender());

        // Save the new student to the database
        sr.save(newStudent);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        // Find a student by email
        Student student = sr.findByEmail(email);

        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Student> loginUser(@RequestBody StudentLoginDto loginDTO) {
        // Find a user by email
        Student user = sr.findByEmail(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            // Authentication successful
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            // Authentication failed
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = sr.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (sr.existsById(id)) {
            sr.deleteById(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editStudent(@PathVariable Long id, @RequestBody StudentDTO sd) {
        // Find the student by ID
        Optional<Student> optionalStudent = sr.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            // Update student properties with the provided data
            student.setUsername(sd.getUsername());
            student.setEmail(sd.getEmail());
            student.setPhone(sd.getPhone());
            student.setBranch(sd.getBranch());
            student.setAddress(sd.getAddress());
            student.setSelectroute(sd.getSelectroute());
            student.setGender(sd.getGender());

            // Save the updated student
            sr.save(student);
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }
    
}
