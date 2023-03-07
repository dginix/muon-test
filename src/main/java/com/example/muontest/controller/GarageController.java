package com.example.muontest.controller;

import com.example.muontest.model.Garage;
import com.example.muontest.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/garage")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping()
    public Collection<Garage> getAllGarage() {
        return garageService.getAllGarage();
    }

    @GetMapping("/{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PostMapping()
    public Garage addGarage(@RequestBody Garage request) {
        Garage res = garageService.addGarage(request);
        return res;
    }
}
