package ru.innopolis.java.homework011;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        CarsRepositoryImpl carsRepository = new CarsRepositoryImpl();

        List<String> carData = Arrays.asList("a123me|Mercedes|White|0|8300000"
                ,"b873of|Volga|Black|0|673000"
                ,"w487mn|Lexus|Grey|76000|900000"
                ,"p987hj|Volga|Red|610|704340"
                ,"c987ss|Toyota|White|254000|761000"
                ,"o983op|Toyota|Black|698000|740000"
                ,"p146op|BMW|White|271000|850000"
                ,"u893ii|Toyota|Purple|210900|440000"
                ,"l097df|Toyota|Black|108000|780000"
                ,"y876wd|Toyota|Black|160000|1000000");

        for (String data : carData) {
            cars.add(carsRepository.parseCar().apply(data));
        }


        System.out.println("Введите цвет или пробег, для которых вывести номера автомобилей");
        String s = "Black, 0";
        System.out.println(s);
        String colorToFind = s.split(", ")[0];
        String mileageToFind = s.split(", ")[1];
        List <String> res = carsRepository.numbersByColorAndMileage(cars, colorToFind, mileageToFind);

        System.out.println("Введите диапазон цен на автомобили, которые нужно вывести");
        s = "700000, 800000";
        System.out.println(s);
        int startCost = Integer.parseInt(s.split(", ")[0]);
        int endCost = Integer.parseInt(s.split(", ")[1]);
        long count = carsRepository.distinctCarsByCost(cars, startCost, endCost);

        String colorOfCheapestCar = carsRepository.colorCarWithMinCost(cars);

        System.out.println("Введите искомую модель, для которой вывести среднюю стоимость");
        String modelToFind = "Toyota";
        System.out.println(modelToFind);
        OptionalDouble avgCost = carsRepository.avgCostByModel(cars, modelToFind);

        System.out.println("Введите искомую модель, для которой вывести среднюю стоимость");
        String modelToFind2 = "Volvo";
        System.out.println(modelToFind2);
        OptionalDouble avgCost2 = carsRepository.avgCostByModel(cars, modelToFind2);

        System.out.println();
        System.out.println("Автомобили в базе:\n" + "Number" + "\t" + "Model" + "\t" + "Color" + "\t" + "Mileage" + "\t" + "Cost");
        System.out.println(carsRepository.printAllCars(cars));
        System.out.println();

        System.out.print("Номера автомобилей по цвету или пробегу: ");
        for (String re : res) {
            System.out.print(re);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println("Уникальные автомобили: " + count + " шт.");

        System.out.println("Цвет автомобиля с минимальной стоимостью : " + colorOfCheapestCar);

        avgCost.ifPresentOrElse(
                cost -> System.out.println("Средняя стоимость модели " + modelToFind + ": " + cost),
                () -> System.out.println("Средняя стоимость модели " + modelToFind + ": 0.0")
        );

        avgCost2.ifPresentOrElse(
                cost -> System.out.println("Средняя стоимость модели " + modelToFind2 + ": " + cost),
                () -> System.out.println("Средняя стоимость модели " + modelToFind2 + ": 0.0")
        );

    }
}
