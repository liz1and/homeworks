package ru.innopolis.java.homework09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        System.out.println("------------Проверим работу Car------------------------------------------------------------");
        Car car = new Car("Toyota", "Corolla", 2015, 120, 8, 6, 8);
        System.out.println("Brand - " + car.getBrand());
        System.out.println("Model - " + car.getModel());
        System.out.println("Year - " + car.getYear());
        System.out.println("Power - " + car.getPower());
        System.out.println("Acceleration - " + car.getAcceleration());
        System.out.println("Suspension - " + car.getSuspension());
        System.out.println("Durability - " + car.getDurability());

        System.out.println("------------------------------------------------------------------------");

        car.setBrand("Honda");
        car.setModel("Civic");
        car.setYear(2020);
        car.setPower(150);
        car.setAcceleration(7);
        car.setSuspension(7);
        car.setDurability(7);
        System.out.println("Установили новые свойства для того же объекта - " + car.toString());

        System.out.println("------------------------------------------------------------------------");

        PerformanceCar performanceCar = new PerformanceCar("BMW", "M3", 2018, 450, 5, 8, 7);

        System.out.println("Проверяем PerformanceCar - " + performanceCar.toString());

        String[] addOns = {"Гоночные шины", "Спортивный выхлоп"};
        performanceCar.setAddOns(addOns);
        System.out.println(Arrays.toString(performanceCar.getAddOns()));

        System.out.println("------------------------------------------------------------------------");

        ShowCar showCar = new ShowCar("Mercedes", "S-Class", 2022, 350, 6, 7, 8);
        showCar.setStars(5);
        System.out.println("Проверяем ShowCar - " + showCar.toString());
        System.out.println("Stars - " + showCar.getStars());

        System.out.println("------------Проверим работу Race------------------------------------------------------------");

        Race race = new Race(10, "Circuit Track", 1000);
        System.out.println("Route - " + race.getRoute());
        System.out.println("Prize - " + race.getPrize());

        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(performanceCar);
        race.setCars(cars);
        System.out.println("Машины, участвующие в гонке - " + race.getCars());

        System.out.println("------------Проверим работу CasualRace------------------------------------------------------------");
        CasualRace casualRace = new CasualRace(5, "City Streets", 500);
        System.out.println("Route - " + casualRace.getRoute());
        System.out.println("Prize - " + casualRace.getPrize());

        System.out.println("------------Проверим работу DragRace------------------------------------------------------------");
        DragRace dragRace = new DragRace(1, "Drag Strip", 800);
        System.out.println("Route - " + dragRace.getRoute());
        System.out.println("Prize - " + dragRace.getPrize());

        System.out.println("------------Проверим работу DriftRace------------------------------------------------------------");
        DriftRace driftRace = new DriftRace(2, "Drift Circuit", 700);
        System.out.println("Route - " + driftRace.getRoute());
        System.out.println("Prize - " + driftRace.getPrize());

        System.out.println("------------Проверим работу Garage------------------------------------------------------------");
        Garage garage = new Garage();
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(showCar);
        garage.setParkedCars(parkedCars);
        System.out.println("Машины, стоящие в гараже - " + garage.getParkedCars().toString());


    }
}
