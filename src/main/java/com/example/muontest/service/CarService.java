package com.example.muontest.service;

import com.example.muontest.dto.CarDto;
import java.util.List;

public interface CarService {
    List<CarDto> getAllCar();
    CarDto getCarById(Long id);
    CarDto addCar(CarDto car);
}
