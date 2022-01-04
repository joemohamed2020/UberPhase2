package com.example.uber.repository;

import com.example.uber.models.TerminatedRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminatedRideRepository extends JpaRepository<TerminatedRide,Integer> {

    List<TerminatedRide> findAllByUserName(String userName);
    List<TerminatedRide> findAllByDriverName(String driverName);
}
