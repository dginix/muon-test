package com.example.muontest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class GarageDto {
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CarDto> cars;

    public GarageDto(Long id, String name, List<CarDto> cars) {
        this.id = id;
        this.name = name;
        this.cars = cars;
    }

    public GarageDto() {
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
