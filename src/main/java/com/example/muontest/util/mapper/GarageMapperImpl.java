package com.example.muontest.util.mapper;

import com.example.muontest.dto.CarDto;
import com.example.muontest.dto.GarageDto;
import com.example.muontest.model.Car;
import com.example.muontest.model.Garage;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
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
                obtainCarDtoList(entity.getCars())
        );
    }

    public List<CarDto> obtainCarDtoList (Collection<Car> carList) {
        if (carList != null) {
            return carList.stream()
                    .map(car -> new CarDto(car.getId(), car.getDriverName(), car.getBrand()))
                    .collect(Collectors.toList());
        }
        else {
            return null;
        }
    }
}
