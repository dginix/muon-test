package com.example.muontest.service;

import com.example.muontest.model.Garage;
import com.example.muontest.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    @Autowired
    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public List<Garage> getAllGarage() {
        return garageRepository.findAll();
    }

    @Override
    public Garage getGarageById(Long id) {
        return garageRepository.findById(id).orElseThrow();
    }

    @Override
    public Garage addGarage(Garage garage) {
        return garageRepository.save(garage);
    }
}
