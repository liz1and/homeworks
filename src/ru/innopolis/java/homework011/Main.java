package ru.innopolis.java.homework011;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        CarsRepositoryImpl carsRepository = new CarsRepositoryImpl();

        //ввод машин
        System.out.println("Введите автомобили");
        String carData;
        do {
            carData = sc.nextLine();
            if (!carData.isEmpty()) {
                cars.add(CarsRepositoryImpl.parseCar().apply(carData));
            }
        } while (!carData.isEmpty());

        System.out.println("Введите цвет или пробег, для которых вывести номера автомобилей");
        String s = sc.nextLine();
        String colorToFind = s.split(", ")[0];
        String mileageToFind = s.split(", ")[1];
        String [] res = carsRepository.numbersByColorAndMileage(cars, colorToFind, mileageToFind);

        System.out.println("Введите диапазон цен на автомобили, которые нужно вывести");
        s = sc.nextLine();
        int startCost = Integer.parseInt(s.split(", ")[0]);
        int endCost = Integer.parseInt(s.split(", ")[1]);
        int count = carsRepository.distinctCarsByCost(cars, startCost, endCost);

        String colorOfCheapestCar = carsRepository.colorCarWithMinCost(cars);

        System.out.println("Введите искомую модель, для которой вывести среднюю стоимость");
        String modelToFind = sc.nextLine();
        OptionalDouble avgCost = carsRepository.avgCostByModel(cars, modelToFind);

        System.out.println("Введите искомую модель, для которой вывести среднюю стоимость");
        String modelToFind2 = sc.nextLine();
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
