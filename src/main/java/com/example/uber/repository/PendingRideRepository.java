package com.example.uber.repository;


import com.example.uber.models.PendingRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PendingRideRepository extends JpaRepository<PendingRide,String> {
    public List<PendingRide> findAllBySource(String source);
    public PendingRide findByUserName(String userName);
    public boolean existsBySource(String source);
    public boolean existsByUserName(String username);
}

