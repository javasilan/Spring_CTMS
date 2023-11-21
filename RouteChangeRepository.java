package com.example.mvccrud.ctms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvccrud.ctms.model.RouteChangeRequest;

public interface RouteChangeRepository extends JpaRepository<RouteChangeRequest, Long> {

	List<RouteChangeRequest> findByApprovedTrue();

	
}
