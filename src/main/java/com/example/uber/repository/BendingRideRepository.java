package com.example.uber.repository;


import com.example.uber.models.BendingRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BendingRideRepository extends JpaRepository<BendingRide,String> {

}

