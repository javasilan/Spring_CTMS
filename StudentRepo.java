package com.example.mvccrud.ctms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mvccrud.ctms.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
    boolean existsByEmail(String id); 
    
    Student findByEmail(String email);
   
}
