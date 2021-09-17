package com.example.demo.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.demo.controller.BicycleController;
import com.example.demo.controller.GearController;
import com.example.demo.entity.Bicycle;
import com.example.demo.entity.CheapGear;
import com.example.demo.entity.Gear;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.GearRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.persistence.EntityNotFoundException;

class BicycleControllerTest {

    @InjectMocks
    BicycleController sut;
    @Mock
    BikeRepository repository;
    @Mock
    GearRepository gearRepository;

    @BeforeEach
    void init() {
        openMocks(this);
    }

    @Test
    void getBike() throws EntityNotFoundException {
        Bicycle bicycle = new Bicycle();
        when(repository.findById(1L)).thenReturn(Optional.of(bicycle));
        assertEquals(bicycle, sut.getBike(1L));
    }

    @Test
    void bicycleNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        try {
            sut.getBike(1L);
            fail();
        } catch (Exception ex) {
            assertTrue(ex instanceof EntityNotFoundException);
        }
    }
    @Test
    void createCheap() throws JsonProcessingException {
        String str = "{\n" +
                "     \"Bicycle\":\n" +
                "            {\n" +
                "                \"frontWheelSize\": 30,\n" +
                "                \"rearWheelSize\": 31\n" +
                "            },\n" +
                "    \"Gear\":\n" +
                "            {\n" +
                "                \"chainTeeth\": 4\n" +
                "            }\n" +
                "}";
        ArgumentCaptor<Bicycle> argument = ArgumentCaptor.forClass(Bicycle.class);
        ArgumentCaptor<Gear> argument2 = ArgumentCaptor.forClass(Gear.class);
        sut.createCheapBike(str);
        verify(repository).save(argument.capture());
        verify(gearRepository).save(argument2.capture());
        assertEquals(30, argument.getValue().getFrontWheelSize());
        assertEquals(31, argument.getValue().getRearWheelSize());
    }
    @Test
    void createExpensive() throws JsonProcessingException {
        String str = "{\n" +
                "     \"Bicycle\":\n" +
                "            {\n" +
                "                \"frontWheelSize\": 30,\n" +
                "                \"rearWheelSize\": 31\n" +
                "            },\n" +
                "    \"Gear\":\n" +
                "            {\n" +
                "                \"chainTeeth\": 4\n" +
                "            }\n" +
                "}";
        ArgumentCaptor<Bicycle> argument = ArgumentCaptor.forClass(Bicycle.class);
        sut.createExpensiveBike(str);

        verify(repository).save(argument.capture());
        assertEquals(30, argument.getValue().getFrontWheelSize());
        assertEquals(31, argument.getValue().getRearWheelSize());

    }
}
