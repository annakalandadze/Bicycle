package com.example.demo.controller;

import com.example.demo.entity.Bicycle;
import com.example.demo.entity.CheapGear;
import com.example.demo.entity.ExpensiveGear;
import com.example.demo.entity.Gear;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.GearRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
@RequestMapping("/bikes")
public class BicycleController {

    final private BikeRepository bikeRepository;
    final private GearRepository gearRepository;

    @Autowired
    public BicycleController(BikeRepository bikeRepository, GearRepository gearRepository) {
        this.bikeRepository = bikeRepository;
        this.gearRepository = gearRepository;
    }

    @GetMapping("/{id}")
    public Bicycle getBike (@PathVariable Long id) throws EntityNotFoundException {
        Optional<Bicycle> bike = bikeRepository.findById(id);
        if (bike.isEmpty()) {
            throw new EntityNotFoundException("Bike '" + id + "' could not be found.");
        }
        return bike.get();
    }

    @PostMapping("/expensive")
    public void createExpensiveBike(@RequestBody String object) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(object);
        Bicycle bicycle = new ObjectMapper().convertValue(jsonNode.get("Bicycle"), Bicycle.class);
        Gear gear = new ObjectMapper().convertValue(jsonNode.get("Gear"), Gear.class);
        gear = new ExpensiveGear(gear.getChainTeeth());
        gear = gearRepository.save(gear);
        bicycle.setGear(gear);
        bikeRepository.save(bicycle);
    }


    @PostMapping("/cheap")
    public void createCheapBike(@RequestBody String object) throws JsonProcessingException {
        JsonNode jsonNode = new ObjectMapper().readTree(object);
        Bicycle bicycle = new ObjectMapper().convertValue(jsonNode.get("Bicycle"), Bicycle.class);
        Gear gear = new ObjectMapper().convertValue(jsonNode.get("Gear"), Gear.class);
        //gear = new CheapGear(gear.getChainTeeth());
        gear = gearRepository.save(gear);
        bicycle.setGear(gear);
        bikeRepository.save(bicycle);
    }

}
