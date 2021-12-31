package com.example.uber.repository;


import com.example.uber.models.BendingRide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BendingRideRepository extends JpaRepository<BendingRide,Integer> {
}

