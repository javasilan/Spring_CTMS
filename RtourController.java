package com.example.mvccrud.ctms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mvccrud.ctms.model.Rtour;
import com.example.mvccrud.ctms.service.RtourService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/faculty")
public class RtourController {

    private final RtourService rtourService;

    @Autowired
    public RtourController(RtourService rtourService) {
        this.rtourService = rtourService;
    }

    @PostMapping("/submit-rtour")
    public ResponseEntity<String> submitRtour(@RequestBody Rtour rtour) {
        try {
            rtourService.submitRtour(rtour);
            return new ResponseEntity<>("Rtour submitted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error submitting Rtour", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/rtours")
    public ResponseEntity<List<Rtour>> getAllRtours() {
        List<Rtour> rtours = rtourService.getAllRtours();
        return new ResponseEntity<>(rtours, HttpStatus.OK);
    }

    @GetMapping("/approved-rtours/{id}")
    public ResponseEntity<Rtour> getApprovedRtourById(@PathVariable Long id) {
        Rtour approvedRtour = rtourService.getRtourById(id);
        
        if (approvedRtour != null) {
            return new ResponseEntity<>(approvedRtour, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/approve-rtour/{id}")
    public ResponseEntity<String> approveRtour(@PathVariable Long id, @RequestBody Map<String, Boolean> requestBody) {
        try {
            // Extract the 'approved' field from the request body
            boolean approved = requestBody.get("approved");
            
            rtourService.processRtour(id, approved);
            return new ResponseEntity<>("Rtour approved/rejected successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing Rtour", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Add more controller methods as needed for other functionalities
}
