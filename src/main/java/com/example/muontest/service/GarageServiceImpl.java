package com.example.muontest.service;

import com.example.muontest.dto.GarageDto;
import com.example.muontest.repository.GarageRepository;
import com.example.muontest.util.mapper.GarageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;
    private final GarageMapper garageMapper;

    @Autowired
    public GarageServiceImpl(GarageRepository garageRepository, GarageMapper garageMapper) {
        this.garageRepository = garageRepository;
        this.garageMapper = garageMapper;
    }

    @Override
    public List<GarageDto> getAllGarage() {
        return garageRepository.findAll().stream()
                .map(garageMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GarageDto getGarageById(Long id) {
        return garageMapper.toDto(
                garageRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Garage not found with this id"))
        );
    }

    @Override
    public GarageDto addGarage(GarageDto garage) {
        return garageMapper.toDto(garageRepository.save(garageMapper.toEntity(garage)));
    }
}
