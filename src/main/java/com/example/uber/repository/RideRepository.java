package com.example.uber.repository;

import com.example.uber.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride,Integer> {
    Ride getAllByUserName(String userName);
    Ride getAllByDriverName(String driverName);
    boolean existsByDriverName(String driverName);
}
