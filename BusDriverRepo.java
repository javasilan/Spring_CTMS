package com.example.mvccrud.ctms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvccrud.ctms.model.BusDriver;


public interface BusDriverRepo extends JpaRepository<BusDriver, Long> {
}
