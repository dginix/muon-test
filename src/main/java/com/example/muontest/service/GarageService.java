package com.example.muontest.service;

import com.example.muontest.model.Garage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GarageService {
    List<Garage> getAllGarage();
    Garage getGarageById(Long id);
    Garage addGarage(Garage garage);
}
