package ru.innopolis.java.homework09;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {

    private String[] addOns;

    public PerformanceCar(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        super(brand, model, year, power, acceleration, suspension, durability);
        super.setPower((int)(1.5 * super.getPower()));
        super.setSuspension((int)(0.75 * super.getSuspension()));
    }
    public String[] getAddOns() {return addOns;}
    public void setAddOns(String[] addOns) {this.addOns = addOns;}

    @Override
    public String toString() {
        return "PerformanceCar" +
                super.toString()  +
                "addOns=" + Arrays.toString(addOns);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }
}
