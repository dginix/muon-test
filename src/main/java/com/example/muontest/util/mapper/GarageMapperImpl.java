package com.example.muontest.util.mapper;

import com.example.muontest.dto.CarDto;
import com.example.muontest.dto.GarageDto;
import com.example.muontest.model.Garage;

import java.util.stream.Collectors;

public class GarageMapperImpl implements GarageMapper{

    @Override
    public Garage toEntity(GarageDto dto) {
        return new Garage(dto.getId(), dto.getName());
    }

    @Override
    public GarageDto toDto(Garage entity) {
        return new GarageDto(
                entity.getId(),
                entity.getName(),
                entity.getCars().stream()
                        .map(car -> new CarDto(
                                car.getId(),
                                car.getDriverName(),
                                car.getBrand()))
                        .collect(Collectors.toList())
        );
    }
}
