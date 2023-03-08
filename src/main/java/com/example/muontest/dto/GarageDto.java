package com.example.muontest.dto;

import java.util.List;

public class GarageDto {
    private Long id;
    private String name;
    private List<CarDto> cars;

    public GarageDto(Long id, String name, List<CarDto> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
