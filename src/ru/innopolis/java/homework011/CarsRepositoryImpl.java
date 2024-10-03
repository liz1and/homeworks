package ru.innopolis.java.homework011;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {

    @Override
    public Function<String, Car> parseCar() {
        return carString -> {
            String[] parts = carString.trim().split("\\|");
            if (parts.length == 5) {
                String vin = parts[0];
                String model = parts[1];
                String color = parts[2];
                int mileage = Integer.parseInt(parts[3]);
                int cost = Integer.parseInt(parts[4]);
                return new Car(vin, model, color, mileage, cost);
            } else {
                throw new IllegalArgumentException("Некорректный ввод " + carString);
            }
        };
    }

    @Override
    public String printAllCars(List<Car> cars) {
        return cars.stream().map(Car::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public List<String> numbersByColorAndMileage(List<Car> cars, String colorToFind, String mileageToFind) {
        return cars.stream()
                .filter(x->x.getColor().equals(colorToFind) || x.getMileage() <= Integer.parseInt(mileageToFind))
                .map(Car::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public long distinctCarsByCost(List<Car> cars, int startCost, int endCost) {
        return  cars.stream()
                .filter(car -> car.getCost() >= startCost && car.getCost() <= endCost)
                .count();
    }

    @Override
    public String colorCarWithMinCost(List<Car> cars) {
        return cars.stream().min(Comparator.comparingInt(Car::getCost))
                .map(Car::getColor)
                .orElse("Нет машин");
    }

    @Override
    public OptionalDouble avgCostByModel(List<Car> cars, String modelToFind) {
        return cars.stream()
                .filter(car -> modelToFind.equals(car.getModel()))
                .mapToInt(Car::getCost)
                .average();
    }
}
