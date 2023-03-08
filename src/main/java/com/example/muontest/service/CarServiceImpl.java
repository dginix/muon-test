package com.example.muontest.service;

import com.example.muontest.dto.CarDto;
import com.example.muontest.exception.GarageCapacityException;
import com.example.muontest.exception.NoSuchElementFoundException;
import com.example.muontest.model.Garage;
import com.example.muontest.repository.CarRepository;
import com.example.muontest.repository.GarageRepository;
import com.example.muontest.util.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final GarageRepository garageRepository;
    private final CarMapper carMapper;

    @Value("${constants.garage.capacity}")
    private Long GARAGE_CAPACITY;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          GarageRepository garageRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> getAllCar() {
        return carRepository.findAll().stream()
                .map(carMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        return carMapper.toDto(
                carRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Car not found with this id"))
        );
    }

    @Override
    public CarDto addCar(CarDto car) {

        Garage thisCarGarage = garageRepository.findById(car.getGarageId())
                .orElseThrow(() -> new NoSuchElementFoundException("Garage with this number does not exist"));

        if (thisCarGarage.getCars().size() >= GARAGE_CAPACITY ) {
            throw new GarageCapacityException("Garage is full");
        }
        else {
            return carMapper.toDto(carRepository.save(carMapper.toEntity(car)));
        }
    }
}
