package com.example.mvccrud.ctms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvccrud.ctms.model.RouteChangeRequest;
import com.example.mvccrud.ctms.repo.RouteChangeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteChangeService {

    private final RouteChangeRepository routeChangeRepository;

    @Autowired
    public RouteChangeService(RouteChangeRepository routeChangeRepository) {
        this.routeChangeRepository = routeChangeRepository;
    }

    public void submitRouteChangeRequest(RouteChangeRequest routeChangeRequest) {
        routeChangeRepository.save(routeChangeRequest);
    }

    public List<RouteChangeRequest> getAllRouteChangeRequests() {
        return routeChangeRepository.findAll();
    }

    public RouteChangeRequest getRouteChangeRequestById(Long requestId) {
        return routeChangeRepository.findById(requestId).orElse(null);
    }

    public void processRouteChangeRequest(Long requestId, boolean approved) {
        RouteChangeRequest request = routeChangeRepository.findById(requestId).orElse(null);
        if (request != null) {
            request.setApproved(approved);
            routeChangeRepository.save(request);
        }
    }

    public List<RouteChangeRequest> getApprovedRouteChangeRequests() {
        return routeChangeRepository.findByApprovedTrue();
    }

    public void deleteRouteChangeRequest(Long id) {
        
        routeChangeRepository.deleteById(id);
    }
}
