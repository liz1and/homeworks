package ru.innopolis.java.homework011;

import java.util.Objects;

public class Car {
    private String number;
    private String model;
    private String color;
    private int mileage;
    private int cost;

    public Car(String number, String model, String color, int mileage, int cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getModel() { return model; }
    public String getNumber() { return number; }
    public String getColor() { return color; }
    public int getMileage() { return mileage; }
    public int getCost() { return cost; }

    public void setNumber(String number) { this.number = number; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setCost(int cost) { this.cost = cost; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && cost == car.cost && Objects.equals(number, car.number) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, model, color, mileage, cost);
    }

    @Override
    public String toString() {
        return number + "\t" +
                model + "\t" +
                color + "\t" +
                mileage + "\t" +
                cost;
    }
}
