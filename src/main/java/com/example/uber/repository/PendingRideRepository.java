package com.example.uber.repository;


import com.example.uber.models.PendingRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PendingRideRepository extends JpaRepository<PendingRide,String> {

}

