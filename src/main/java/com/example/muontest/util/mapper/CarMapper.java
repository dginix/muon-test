package com.example.muontest.util.mapper;

import com.example.muontest.dto.CarDto;
import com.example.muontest.model.Car;
import com.example.muontest.model.Garage;

public interface CarMapper {
    Car toEntity(CarDto dto);
    CarDto toDto(Car entity);
    Long obtainGarageId(Garage garage);
    Garage obtainGarage(Long garageId);
}
