package com.example.mvccrud.ctms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvccrud.ctms.model.BusDriver;
import com.example.mvccrud.ctms.repo.BusDriverRepo;



	
	@RestController
	@RequestMapping("/api/busdriver")
	@CrossOrigin(origins = "http://localhost:3000")
	public class BusDriverController {

	    @Autowired
	    private BusDriverRepo busDriverRepository;

	    @GetMapping
	    public List<BusDriver> getAllBusDrivers() {
	        return busDriverRepository.findAll();
	    }

	    @PostMapping
	    public BusDriver addBusDriver(@RequestBody BusDriver busDriver) {
	        return busDriverRepository.save(busDriver);
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBusDriver(@PathVariable Long id) {
	        Optional<BusDriver> existingDriver = busDriverRepository.findById(id);
	        if (existingDriver.isPresent()) {
	            busDriverRepository.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<BusDriver> updateBusDriver(@PathVariable Long id, @RequestBody BusDriver updatedDriver) {
	        Optional<BusDriver> existingDriver = busDriverRepository.findById(id);
	        if (existingDriver.isPresent()) {
	            BusDriver busDriver = existingDriver.get();
	            busDriver.setName(updatedDriver.getName());
	            busDriver.setMobileNumber(updatedDriver.getMobileNumber());
	            // Add other fields as needed

	            BusDriver updatedBusDriver = busDriverRepository.save(busDriver);
	            return new ResponseEntity<>(updatedBusDriver, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}

	
	

