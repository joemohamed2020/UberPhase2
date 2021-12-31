package com.example.uber.repository;

import com.example.uber.models.DriverData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<DriverData,String> {
}
