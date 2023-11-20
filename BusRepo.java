package com.example.mvccrud.ctms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvccrud.ctms.model.Bus;

public interface BusRepo extends JpaRepository<Bus, Long> {
}

