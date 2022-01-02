package com.example.uber.repository;

import com.example.uber.models.FavoriteAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavAreaRepository extends JpaRepository<FavoriteAreas,Integer> {

    List<FavoriteAreas> findAllByDriverName(String driverName);
    boolean existsByDriverName(String driverName);
}
