package com.example.muontest.controller;

import com.example.muontest.model.Garage;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/garage")
public class GarageController {

    @GetMapping("/")
    public Collection<Garage> getAllGarage() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public Garage getGarageById(@PathVariable Long id) {
        return new Garage();
    }

    @PostMapping("/")
    public Garage addGarage(@RequestBody Garage request) {
        return new Garage();
    }
}
