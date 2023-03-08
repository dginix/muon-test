package com.example.muontest.repository;

import com.example.muontest.model.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Long> {
    @Query(value = "Select g FROM Garage g LEFT JOIN FETCH g.cars cars")
    List<Garage> findAllGarage();
}
