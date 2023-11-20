package com.example.mvccrud.ctms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mvccrud.ctms.model.Bus;
import com.example.mvccrud.ctms.repo.BusRepo;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {

    @Autowired
    private BusRepo br;

    @PostMapping
    public Bus createBus(@RequestBody Bus bus) {
        return br.save(bus);
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return br.findAll();
    }
}
