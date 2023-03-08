package com.example.muontest.service;

import com.example.muontest.dto.GarageDto;
import java.util.List;

public interface GarageService {
    List<GarageDto> getAllGarage();
    GarageDto getGarageById(Long id);
    GarageDto addGarage(GarageDto garage);
}
