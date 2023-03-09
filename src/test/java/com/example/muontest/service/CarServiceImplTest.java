package com.example.muontest.service;

import com.example.muontest.dto.CarDto;
import com.example.muontest.model.Car;
import com.example.muontest.model.Garage;
import com.example.muontest.repository.CarRepository;
import com.example.muontest.repository.GarageRepository;
import com.example.muontest.util.mapper.CarMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRepository carRepository;
    @Mock
    private GarageRepository garageRepository;
    @Mock
    private CarMapper carMapper;
    @InjectMocks
    private CarServiceImpl carService;

    @Test
    void getCarById_ShouldCallRepository() throws NoSuchElementException {
        final Long carId = 1L;

        final Car car = mock(Car.class);
        final CarDto carDto = mock(CarDto.class);

        when(carMapper.toDto(car)).thenReturn(carDto);

        when(carRepository.findById(carId)).thenReturn(Optional.of(car));

        final CarDto carActual = carService.getCarById(carId);

        assertNotNull(carActual);
        assertEquals(carDto, carActual);
        verify(carRepository).findById(carId);
    }

    @Test
    void getAllCar_ShouldCallRepository() {
        Car car1 = mock(Car.class);
        Car car2 = mock(Car.class);
        Car car3 = mock(Car.class);

        CarDto carDto1 = mock(CarDto.class);
        CarDto carDto2 = mock(CarDto.class);
        CarDto carDto3 = mock(CarDto.class);

        List<Car> carList = List.of(car1, car2, car3);
        List<CarDto> carDtoList = List.of(carDto1, carDto2, carDto3);
        when(carMapper.toDto(car1)).thenReturn(carDto1);
        when(carMapper.toDto(car2)).thenReturn(carDto2);
        when(carMapper.toDto(car3)).thenReturn(carDto3);

        when(carRepository.findAll()).thenReturn(carList);

        List<CarDto> actual = carService.getAllCar();

        assertNotNull(actual);
        assertIterableEquals(carDtoList, actual);
        verify(carRepository).findAll();
    }

    @Test
    void addCar_ShouldCallRepository() {
        final Long carId = 1L;
        final Long garageId = 1L;
        List<Car> cars = new ArrayList<>();
        final Garage garage = new Garage(garageId, "garage 1", cars);
        final Car car = new Car(carId, "Andrey", "BMW", garage);
        final CarDto carDto = new CarDto(carId, "Andrey", "BMW", garageId);

        when(carMapper.toDto(car)).thenReturn(carDto);
        when(carMapper.toEntity(carDto)).thenReturn(car);

        when(carRepository.save(car)).thenReturn(car);
        when(garageRepository.findById(garageId)).thenReturn(Optional.of(garage));

        ReflectionTestUtils.setField(carService, "GARAGE_CAPACITY", 2L);

        final CarDto actual = carService.addCar(carDto);

        assertNotNull(actual);
        assertEquals(carDto, actual);
        verify(carRepository).save(car);
        verify(garageRepository).findById(garageId);
    }
}