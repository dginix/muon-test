package com.example.muontest.util.mapper;

import com.example.muontest.dto.GarageDto;
import com.example.muontest.model.Garage;

public interface GarageMapper {
    Garage toEntity(GarageDto dto);
    GarageDto toDto(Garage entity);
}
