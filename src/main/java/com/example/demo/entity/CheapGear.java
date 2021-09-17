package com.example.demo.entity;

import javax.persistence.Entity;

@Entity
public class CheapGear extends Gear {

    public CheapGear(int chainTeeth) {
        super(chainTeeth);
        this.setGearLevel(7);
        this.setSprocketTeeth((int) (30-2*this.getGearLevel()));
        this.setGearRatio((double)chainTeeth/(double) this.getSprocketTeeth());
    }

    public CheapGear() {
    }

}