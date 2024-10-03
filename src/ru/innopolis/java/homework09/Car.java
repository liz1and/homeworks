package ru.innopolis.java.homework09;

import java.util.Objects;

public class Car {

    private String brand; //марка
    private String model; //модель
    private int year; //год выпуска
    private int power; //мощность двигателя
    private int acceleration; //ускорение
    private int suspension; //подвеска
    private int durability; //долговечность

    public Car(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.power = power;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {return this.brand;}
    public String getModel() {return this.model;}
    public int getYear() {return this.year;}
    public int getPower() {return this.power;}
    public int getAcceleration() {return this.acceleration;}
    public int getSuspension() {return this.suspension;}
    public int getDurability() {return this.durability;}

    public void setBrand(String brand) {this.brand = brand;}
    public void setModel(String model) {this.model = model;}
    public void setYear(int year) {this.year = year;}
    public void setPower(int power) {this.power = power;}
    public void setAcceleration(int acceleration) {this.acceleration = acceleration;}
    public void setSuspension(int suspension) {this.suspension = suspension;}
    public void setDurability(int durability) {this.durability = durability;}

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", power=" + power +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && power == car.power && acceleration == car.acceleration && suspension == car.suspension && durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, power, acceleration, suspension, durability);
    }
}
