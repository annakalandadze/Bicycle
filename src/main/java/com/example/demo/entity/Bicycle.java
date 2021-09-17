package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

/*This is bicycle. It has 2 wheels (can be diff sizes) and a gear*/

@Entity
@Table(name="bicycle")
public class Bicycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int frontWheelSize;
    private int rearWheelSize;

    @OneToOne
    private Gear gear;

    public Bicycle() {
    }

    public Bicycle(int frontWheelSize, int rearWheelSize) {
        this.frontWheelSize = frontWheelSize;
        this.rearWheelSize = rearWheelSize;
    }

    public int getFrontWheelSize() {
        return frontWheelSize;
    }

    public int getRearWheelSize() {
        return rearWheelSize;
    }

    public float cycle(float numOfRotations) {
        return (float) (this.rearWheelSize * this.gear.getGearRatio() * numOfRotations);
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return frontWheelSize == bicycle.frontWheelSize && rearWheelSize == bicycle.rearWheelSize && Objects.equals(gear, bicycle.gear);
    }
}
