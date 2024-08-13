package ru.innopolis.java.homework09;

import java.util.List;

public class Race {
    private int length;
    private String route;
    private int prize;
    private List<Car> cars;

    public Race(int length, String route, int prize) {
        this.length = length;
        this.route = route;
        this.prize = prize;
    }

    public int getLength() {return length;}
    public String getRoute() {return route;}
    public int getPrize() {return prize;}
    public List<Car> getCars() {return cars;}

    public void setLength(int length) {this.length = length;}
    public void setRoute(String route) {this.route = route;}
    public void setPrize(int prize) {this.prize = prize;}
    public void setCars(List<Car> cars) {this.cars = cars;}

}
