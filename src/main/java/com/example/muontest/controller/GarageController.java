package com.example.muontest.controller;

import com.example.muontest.dto.GarageDto;
import com.example.muontest.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/garage")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping()
    public Collection<GarageDto> getAllGarage() {
        return garageService.getAllGarage();
    }

    @GetMapping("/{id}")
    public GarageDto getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PostMapping()
    public GarageDto addGarage(@RequestBody GarageDto request) {
        return garageService.addGarage(request);
    }
}
