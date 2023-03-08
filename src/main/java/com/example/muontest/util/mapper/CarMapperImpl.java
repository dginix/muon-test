package com.example.muontest.util.mapper;

import com.example.muontest.dto.CarDto;
import com.example.muontest.model.Car;
import com.example.muontest.model.Garage;
import com.example.muontest.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements CarMapper {
    private final GarageRepository garageRepository;

    @Autowired
    public CarMapperImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }


    @Override
    public Car toEntity(CarDto dto) {
        return new Car(
                dto.getId(),
                dto.getDriverName(),
                dto.getBrand(),
                obtainGarage(dto.getGarageId())
        );
    }

    @Override
    public CarDto toDto(Car entity) {
        return new CarDto(
                entity.getId(),
                entity.getDriverName(),
                entity.getBrand(),
                obtainGarageId(entity.getGarage())
        );
    }

    @Override
    public Long obtainGarageId(Garage garage) {
        if (garage != null) {
            return garage.getId();
        }
        else {
            return null;
        }
    }

    @Override
    public Garage obtainGarage(Long garageId) {
        if (garageId != null) {
            return garageRepository.findById(garageId).orElse(null);
        }
        else {
            return null;
        }
    }
}
