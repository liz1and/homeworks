package ru.innopolis.java.homework09;

public class PerformanceCar extends Car {

    private String[] addOns;

    public PerformanceCar(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        super(brand, model, year, power, acceleration, suspension, durability);
        super.setPower((int)(1.5 * super.getPower()));
        super.setSuspension((int)(0.75 * super.getSuspension()));
    }
    public String[] getAddOns() {return addOns;}
    public void setAddOns(String[] addOns) {this.addOns = addOns;}

}
