package com.example.mvccrud.ctms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mvccrud.ctms.DTO.FacultyDTO; // Updated import for FacultyDTO
import com.example.mvccrud.ctms.DTO.FacultyLoginDto; // Updated import for FacultyLoginDto
import com.example.mvccrud.ctms.model.Faculty; // Updated import for Faculty
import com.example.mvccrud.ctms.repo.FacultyRepo; // Updated import for FacultyRepo

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepo fr; // Updated repository for Faculty

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody FacultyDTO fd) {
        // Check if a user with the provided email already exists
        if (fr.existsByEmail(fd.getId())) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }

        // Create a new Faculty object and set its properties
        Faculty newFaculty = new Faculty();
        newFaculty.setUsername(fd.getUsername());
        newFaculty.setPassword(fd.getPassword());
        newFaculty.setEmail(fd.getId());
        newFaculty.setPhone(fd.getPhone());
        newFaculty.setDept(fd.getDept());
        newFaculty.setAddress(fd.getAddress());
        newFaculty.setSelectroute(fd.getSelectroute());
        newFaculty.setGender(fd.getGender());

        // Save the new faculty to the database
        fr.save(newFaculty);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Faculty> getFacultyByEmail(@PathVariable String email) {
        // Find a faculty by email
        Faculty faculty = fr.findByEmail(email);

        if (faculty != null) {
            return new ResponseEntity<>(faculty, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Faculty> loginUser(@RequestBody FacultyLoginDto loginDTO) {
        // Find a user by email
        Faculty user = fr.findByEmail(loginDTO.getEmail());

        if (user != null && user.getPassword().equals(loginDTO.getPassword())) {
            // Authentication successful
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            // Authentication failed
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Faculty>> getAllStudents() {
        List<Faculty> students = fr.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        if (fr.existsById(id)) {
            fr.deleteById(id);
            return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editStudent(@PathVariable Long id, @RequestBody FacultyDTO sd) {
        // Find the student by ID
        Optional<Faculty> optionalStudent = fr.findById(id);

        if (optionalStudent.isPresent()) {
            Faculty student = optionalStudent.get();
            // Update student properties with the provided data
            student.setUsername(sd.getUsername());
            student.setEmail(sd.getEmail());
            student.setPhone(sd.getPhone());
            student.setDept(sd.getDept());
            student.setAddress(sd.getAddress());
            student.setSelectroute(sd.getSelectroute());
            student.setGender(sd.getGender());

            // Save the updated student
            fr.save(student);
            return new ResponseEntity<>("Student updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
        }
    }

 
}
