package com.example.uber.repository;

import com.example.uber.models.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride,Integer> {
    List<Ride> getAllByUserName(String userName);
    List<Ride> getAllByDriverName(String driverName);
}
