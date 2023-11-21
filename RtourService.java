package com.example.mvccrud.ctms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvccrud.ctms.model.Rtour;
import com.example.mvccrud.ctms.repo.RtourRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RtourService {

    private final RtourRepo rtourRepo;

    @Autowired
    public RtourService(RtourRepo rtourRepo) {
        this.rtourRepo = rtourRepo;
    }

    public void submitRtour(Rtour rtour) {
        rtourRepo.save(rtour);
    }

    public List<Rtour> getAllRtours() {
        return rtourRepo.findAll();
    }

    public Rtour getRtourById(Long rtourId) {
        return rtourRepo.findById(rtourId).orElse(null);
    }

    public void processRtour(Long rtourId, boolean approved) {
        Rtour rtour = rtourRepo.findById(rtourId).orElse(null);
        if (rtour != null) {
            rtour.setApproved(approved);
            rtourRepo.save(rtour);
        }
    }

    public List<Rtour> getApprovedRtours() {
        return rtourRepo.findByApprovedTrue();
    }
}
