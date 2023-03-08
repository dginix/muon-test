package com.example.muontest.controller;

import com.example.muontest.dto.CarDto;
import com.example.muontest.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public Collection<CarDto> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping()
    public CarDto addCar(@RequestBody @Valid CarDto request) {
        return carService.addCar(request);
    }
}
