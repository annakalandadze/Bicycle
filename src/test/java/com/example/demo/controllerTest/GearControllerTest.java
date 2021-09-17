package com.example.demo.controllerTest;

import com.example.demo.controller.BicycleController;
import com.example.demo.controller.GearController;
import com.example.demo.entity.Bicycle;
import com.example.demo.entity.CheapGear;
import com.example.demo.entity.Gear;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.GearRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class GearControllerTest {
    @InjectMocks
    GearController sut;
    @Mock
    BikeRepository repository;
    @Mock
    GearRepository gearRepository;

    @BeforeEach
    void init() {
        openMocks(this);
    }

    @Test
    void incrLevel() {
        Gear gear = new CheapGear(10);
        ArgumentCaptor<Gear> argument = ArgumentCaptor.forClass(Gear.class);
        when(gearRepository.findById(1L)).thenReturn(Optional.of(gear));
        sut.increment(1L);
        verify(gearRepository).incrementLevel(1L);
    }
    @Test
    void decrLevel() {
        Gear gear = new CheapGear(10);
        ArgumentCaptor<Gear> argument = ArgumentCaptor.forClass(Gear.class);
        when(gearRepository.findById(1L)).thenReturn(Optional.of(gear));
        sut.decrement(1L);
        verify(gearRepository).decrementLevel(1L);
    }

    @Test
    void incrEmpty() {
        when(gearRepository.findById(1L)).thenReturn(Optional.empty());
        try {
            sut.increment(1L);
            fail();
        } catch (Exception ex) {
            assertTrue(ex instanceof EntityNotFoundException);
        }
    }
    @Test
    void decrEmpty() {
        when(gearRepository.findById(1L)).thenReturn(Optional.empty());
        try {
            sut.decrement(1L);
            fail();
        } catch (Exception ex) {
            assertTrue(ex instanceof EntityNotFoundException);
        }
    }
}
