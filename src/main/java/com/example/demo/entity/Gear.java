package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;
/*This is a gear class.
It has everything connected to a gear bike. The chose to use additional class (not in bike) was made due to
not trivial construction of gear (as it has many own fields).
*/

@Entity
public class Gear {
    private int chainTeeth;
    private int gearLevel;
    private int sprocketTeeth;
    private double gearRatio;
    /*Ids are generated numerically*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Gear(int chainTeeth) {
        this.chainTeeth = chainTeeth;
    }

    public Gear() {

    }

    /*getters*/

    public Long getId() {
        return id;
    }

    public int getGearLevel() {
        return gearLevel;
    }

    public int getChainTeeth() {
        return chainTeeth;
    }

    public int getSprocketTeeth() {
        return sprocketTeeth;
    }

    public double getGearRatio() {
        return gearRatio;
    }

    /*setters*/

    public void setSprocketTeeth(int sprocketTeeth) {
        this.sprocketTeeth = sprocketTeeth;
    }

    public void setGearRatio(double sprocketRatio) {
        this.gearRatio = sprocketRatio;
    }

    public void setGearLevel(int gearLevel) {
        this.gearLevel = gearLevel;
    }

    public void setChainTeeth(int chainTeeth) {
        this.chainTeeth = chainTeeth;
    }

    /*2 methods from task*/
    public void increaseGear()  {
        this.gearLevel++;
    }

    public void decreaseGear()  {
        this.gearLevel--;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "chainTeeth=" + chainTeeth +
                ", gearLevel=" + gearLevel +
                ", id=" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gear gear = (Gear) o;
        return chainTeeth == gear.chainTeeth && gearLevel == gear.gearLevel && sprocketTeeth == gear.sprocketTeeth && Double.compare(gear.gearRatio, gearRatio) == 0 && Objects.equals(id, gear.id);
    }
}
