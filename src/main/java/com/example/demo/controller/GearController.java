package com.example.demo.controller;


import com.example.demo.entity.Bicycle;
import com.example.demo.entity.Gear;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.GearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/gears")
public class GearController {
    @Autowired
    private GearRepository gearRepository;
    @Autowired
    private BikeRepository bikeRepository;

    @PatchMapping("/{id}/incr")
    public void increment(@PathVariable Long id) throws EntityNotFoundException{
        Optional<Gear> existing = gearRepository.findById(id);
        if (existing.isEmpty()) {
            throw new EntityNotFoundException("Invalid gear id.");
        }
        gearRepository.incrementLevel(id);
    }

    @PatchMapping("/{id}/decr")
    public void decrement(@PathVariable Long id) throws EntityNotFoundException{
        Optional<Gear> existing = gearRepository.findById(id);
        if (existing.isEmpty()) {
            throw new EntityNotFoundException("Invalid gear id.");
        }
        gearRepository.decrementLevel(id);
    }
}
