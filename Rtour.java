package com.example.mvccrud.ctms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rtour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String facultyName;
    private String department;
    private String studyTour;
    private boolean approved;

    // Constructors, getters, and setters can be added here

    public Rtour() {
        // Default constructor
    }

    // Constructor
    public Rtour(Long id, String facultyName, String department, String studyTour, boolean approved) {
        this.id = id;
        this.facultyName = facultyName;
        this.department = department;
        this.studyTour = studyTour;
        this.approved = approved;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudyTour() {
        return studyTour;
    }

    public void setStudyTour(String studyTour) {
        this.studyTour = studyTour;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    // You can add additional methods or functionality as needed
}
