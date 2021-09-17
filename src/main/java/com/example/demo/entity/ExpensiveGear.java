package com.example.demo.entity;

import javax.persistence.Entity;

@Entity
public class ExpensiveGear extends Gear {

    public ExpensiveGear(int chainTeeth) {
        super(chainTeeth);
        this.setGearLevel(30);
        this.setSprocketTeeth((int) (46-Math.floor(1.2*this.getGearLevel())));
        this.setGearRatio((double)chainTeeth/(double) this.getSprocketTeeth());
    }

    public ExpensiveGear() {
    }
}