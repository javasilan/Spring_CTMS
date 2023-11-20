package com.example.mvccrud.ctms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mvccrud.ctms.model.Faculty; // Import the Faculty entity

public interface FacultyRepo extends JpaRepository<Faculty, Long> {

    boolean existsByEmail(String email); 

    Faculty findByEmail(String email); 
}
