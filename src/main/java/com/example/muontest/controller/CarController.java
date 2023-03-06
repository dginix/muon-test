package com.example.muontest.controller;

import com.example.muontest.model.Car;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @GetMapping("/")
    public Collection<Car> getAllCar() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return new Car();
    }

    @PostMapping("/")
    public Car addCar(@RequestBody Car request) {
        return new Car();
    }
}
