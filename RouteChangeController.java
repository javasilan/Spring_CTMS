package com.example.mvccrud.ctms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.mvccrud.ctms.model.RouteChangeRequest;
import com.example.mvccrud.ctms.service.RouteChangeService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class RouteChangeController {

    private final RouteChangeService routeChangeService;

    @Autowired
    public RouteChangeController(RouteChangeService routeChangeService) {
        this.routeChangeService = routeChangeService;
    }

    @PostMapping("/route-change-request")
    public ResponseEntity<String> submitRouteChangeRequest(@RequestBody RouteChangeRequest routeChangeRequest) {
        try {
            routeChangeService.submitRouteChangeRequest(routeChangeRequest);
            return new ResponseEntity<>("Route change request submitted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error submitting route change request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/route-change-requests")
    public ResponseEntity<List<RouteChangeRequest>> getAllRouteChangeRequests() {
        List<RouteChangeRequest> requests = routeChangeService.getAllRouteChangeRequests();
        return new ResponseEntity<>(requests, HttpStatus.OK);
    }

    @PutMapping("/approve-request/{id}")
    public ResponseEntity<String> approveRequest(@PathVariable Long id, @RequestBody Map<String, Boolean> requestBody) {
        try {
            // Extract the 'approved' field from the request body
            boolean approved = requestBody.get("approved");
            
            routeChangeService.processRouteChangeRequest(id, approved);
            return new ResponseEntity<>("Request approved/rejected successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // New API endpoint for deleting an approved request
    @DeleteMapping("/delete-request/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Long id) {
        try {
            routeChangeService.deleteRouteChangeRequest(id);
            return new ResponseEntity<>("Request deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error deleting request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
