package com.example.muontest.service;

import com.example.muontest.model.Car;
import java.util.List;

public interface CarService {
    List<Car> getAllCar();
    Car getCarById(Long id);
    Car addCar(Car car);
}
