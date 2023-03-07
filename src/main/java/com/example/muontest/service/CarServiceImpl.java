package com.example.muontest.service;

import com.example.muontest.exception.GarageCapacityException;
import com.example.muontest.exception.NoSuchElementFoundException;
import com.example.muontest.model.Car;
import com.example.muontest.repository.CarRepository;
import com.example.muontest.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    @Value("${constants.garage.capacity}")
    private Long GARAGE_CAPACITY;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          GarageRepository garageRepository) {
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public Car addCar(Car car) {
        Long thisCarGarageId = car.getGarage().getId();
        if (garageRepository.existsById(thisCarGarageId)) {
            if (garageRepository.findById(thisCarGarageId).get().getCars().size() >= GARAGE_CAPACITY) {
                throw new GarageCapacityException("Garage is full");
            }
            else {
                return carRepository.save(car);
            }
        }
        else {
            throw new NoSuchElementFoundException("Garage with this number does not exist");
        }
    }
}
