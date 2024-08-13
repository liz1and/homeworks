package ru.innopolis.java.homework09;

public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int year, int power, int acceleration, int suspension, int durability) {
        super(brand, model, year, power, acceleration, suspension, durability);
        this.stars = 0;
    }
    public int getStars() {return stars;}
    public void setStars(int stars) {this.stars = stars;}
}
