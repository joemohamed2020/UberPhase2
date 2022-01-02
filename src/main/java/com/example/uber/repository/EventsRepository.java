package com.example.uber.repository;

import com.example.uber.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Event,Integer> {
public List<Event> getAllByRideId(int id);
public boolean existsByRideId(int id);
}
