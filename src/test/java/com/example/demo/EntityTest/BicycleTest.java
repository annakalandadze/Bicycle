package com.example.demo.EntityTest;

import com.example.demo.entity.Bicycle;
import com.example.demo.entity.CheapGear;
import com.example.demo.entity.Gear;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BicycleTest {

    Bicycle bicycle = new Bicycle(4, 1);
    Gear gear = new CheapGear(20);

    @Test
    void testEmpty() {
        Bicycle b = new Bicycle();
        assertNotNull(b);
    }

    @Test
    void testConstructor() {
        assertNotNull(bicycle);
        assertEquals(4, bicycle.getFrontWheelSize());
        assertEquals(1, bicycle.getRearWheelSize());
    }

    @Test
    void testSetters() {
        Gear gear = new Gear(1);
        bicycle.setGear(gear);
        assertEquals(gear, bicycle.getGear());
    }

    @Test
    void testCycle() {
        bicycle.setGear(gear);
        assertEquals(2.5f, bicycle.cycle(2));
    }

    @Test
    void testEquals() {
        Bicycle bicycle2 = new Bicycle(4, 1);
        bicycle.setGear(gear);
        bicycle2.setGear(gear);
        assertEquals(bicycle, bicycle2);
    }
}

