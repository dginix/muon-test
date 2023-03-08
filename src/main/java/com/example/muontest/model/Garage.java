package com.example.muontest.model;

import com.example.muontest.util.json.GarageSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "garage")
@JsonSerialize(using = GarageSerializer.class)
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<Car> Cars;

    public Garage() {
    }

    public Garage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Garage(Long id, String name, List<Car> cars) {
        this.id = id;
        this.name = name;
        Cars = cars;
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

    public List<Car> getCars() {
        return Cars;
    }

    public void setCars(List<Car> cars) {
        Cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Garage garage = (Garage) o;
        return id != null && Objects.equals(id, garage.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
