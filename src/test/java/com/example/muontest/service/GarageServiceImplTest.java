package com.example.muontest.service;

import com.example.muontest.dto.GarageDto;
import com.example.muontest.model.Garage;
import com.example.muontest.repository.GarageRepository;
import com.example.muontest.util.mapper.GarageMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GarageServiceImplTest {

    @Mock
    private GarageRepository garageRepository;

    @Mock
    private GarageMapper garageMapper;

    @InjectMocks
    private GarageServiceImpl garageService;


    @Test
    void getAllGarage_ShouldCallRepository() {
        List<Garage> garages = new ArrayList<>();
        Garage garage1 = new Garage();
        garage1.setId(1L);
        garage1.setName("Garage 1");
        garages.add(garage1);
        Garage garage2 = new Garage();
        garage2.setId(2L);
        garage2.setName("Garage 2");
        garages.add(garage2);
        when(garageRepository.findAllGarage()).thenReturn(garages);
        GarageDto garageDto1 = new GarageDto();
        garageDto1.setId(1L);
        garageDto1.setName("Garage 1");
        when(garageMapper.toDto(garage1)).thenReturn(garageDto1);
        GarageDto garageDto2 = new GarageDto();
        garageDto2.setId(2L);
        garageDto2.setName("Garage 2");
        when(garageMapper.toDto(garage2)).thenReturn(garageDto2);

        List<GarageDto> garageDtos = garageService.getAllGarage();

        assertEquals(2, garageDtos.size());
        assertEquals(garageDto1, garageDtos.get(0));
        assertEquals(garageDto2, garageDtos.get(1));
        verify(garageRepository).findAllGarage();
    }

    @Test
    void getGarageById_ShouldCallRepository() {
        // given
        Long id = 1L;
        Garage garage = new Garage();
        garage.setId(id);
        garage.setName("Garage 1");
        when(garageRepository.findById(id)).thenReturn(Optional.of(garage));
        GarageDto garageDto = new GarageDto();
        garageDto.setId(id);
        garageDto.setName("Garage 1");
        when(garageMapper.toDto(garage)).thenReturn(garageDto);

        GarageDto result = garageService.getGarageById(id);

        assertEquals(garageDto, result);
        verify(garageRepository).findById(any());
    }

    @Test
    void addGarage_ShouldCallRepository() {
        GarageDto garageDto = new GarageDto();
        garageDto.setId(1L);
        garageDto.setName("Test Garage");

        Garage garage = new Garage();
        garage.setId(1L);
        garage.setName("Test Garage");

        when(garageMapper.toEntity(garageDto)).thenReturn(garage);
        when(garageRepository.save(garage)).thenReturn(garage);
        when(garageMapper.toDto(garage)).thenReturn(garageDto);

        GarageDto result = garageService.addGarage(garageDto);

        assertEquals(garageDto, result);
        verify(garageRepository).save(garage);
    }
}