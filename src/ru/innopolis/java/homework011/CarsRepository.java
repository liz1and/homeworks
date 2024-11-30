package ru.innopolis.java.homework011;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;

public interface CarsRepository {
    Function<String, Car> parseCar();
    String printAllCars(List<Car> cars);
    List <String> numbersByColorAndMileage(List<Car> cars, String colorToFind, String mileageToFind);
    long distinctCarsByCost (List<Car> cars, int startCost, int endCost);
    String colorCarWithMinCost (List<Car> cars);
    OptionalDouble avgCostByModel (List<Car> cars, String modelToFind);
}
