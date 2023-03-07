package com.example.muontest.controller;

import com.example.muontest.model.Car;
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
    public Collection<Car> getAllCar() {
        return carService.getAllCar();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping()
    public Car addCar(@RequestBody @Valid Car request) {
        return carService.addCar(request);
    }
}
