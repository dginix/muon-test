package com.example.muontest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Pattern;

public class CarDto {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Driver name must contain only letters")
    private String driverName;
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Brand must contain only letters")
    private String brand;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long garageId;

    public CarDto(Long id, String driverName, String brand, Long garageId) {
        this.id = id;
        this.driverName = driverName;
        this.brand = brand;
        this.garageId = garageId;
    }

    public CarDto(Long id, String driverName, String brand) {
        this.id = id;
        this.driverName = driverName;
        this.brand = brand;
    }

    public CarDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }
}
