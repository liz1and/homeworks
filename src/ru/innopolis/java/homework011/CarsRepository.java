package ru.innopolis.java.homework011;

import java.util.List;
import java.util.OptionalDouble;

public interface CarsRepository {
    String printAllCars(List<Car> cars);
    String [] numbersByColorAndMileage(List<Car> cars, String colorToFind, String mileageToFind);
    int distinctCarsByCost (List<Car> cars, int startCost, int endCost);
    String colorCarWithMinCost (List<Car> cars);
    OptionalDouble avgCostByModel (List<Car> cars, String modelToFind);
}
