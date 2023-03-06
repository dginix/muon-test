package com.example.muontest.service;

import com.example.muontest.model.Garage;
import java.util.List;

public interface GarageService {
    List<Garage> getAllGarage();
    Garage getGarageById(Long id);
    Garage addGarage(Garage garage);
}
