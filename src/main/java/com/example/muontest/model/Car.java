package com.example.muontest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import org.hibernate.Hibernate;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Objects;

@Entity
@Table(name = "car")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Driver name must contain only letters")
    @Column(name = "driver_name", nullable = false)
    private String driverName;

    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Brand must contain only letters")
    @Column(name = "brand", nullable = false)
    private String brand;

    @ManyToOne(optional = false)
    @JoinColumn(name = "garage_id")
    private Garage garage;

    public Car(Long id, String driverName, String brand, Garage garage) {
        this.id = id;
        this.driverName = driverName;
        this.brand = brand;
        this.garage = garage;
    }

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Car car = (Car) o;
        return id != null && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
