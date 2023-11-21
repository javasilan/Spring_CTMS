package com.example.mvccrud.ctms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvccrud.ctms.model.Rtour;

@Repository
public interface RtourRepo extends JpaRepository<Rtour, Long> {

	 List<Rtour> findByApprovedTrue();

}
