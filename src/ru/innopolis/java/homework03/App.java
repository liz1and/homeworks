package ru.innopolis.java.homework03;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Создаем tv");
        TV tv = new TV();
        System.out.println("Проверяем включен ли tv: " + tv.isWorking());
        System.out.println("");
        System.out.println(tv.toString());

        System.out.println("");

        System.out.println("Создаем tv2 включенным");
        TV tv2 = new TV(true);
        System.out.println("Проверяем включен ли tv2: " + tv2.isWorking());
        System.out.println("Выключаем tv2");
        tv2.turnOff();
        System.out.println("Проверяем включен ли tv2: " + tv2.isWorking());
        System.out.println("Включаем tv2");
        tv2.turnOn();
        System.out.println("Проверяем включен ли tv2: " + tv2.isWorking());

        System.out.println("");

        System.out.print("Какой на какой канал переключиться? ");
        int choice = sc.nextInt();
        System.out.println("Переключаемся на " + choice + " канал");
        tv2.switchChannel(choice);
        System.out.println("Текущий канал у tv2: " + tv2.getChannel());

        System.out.println("");

        Random r = new Random();
        choice = r.nextInt(10);
        System.out.println("Получили рандомное число - " + choice);
        System.out.println("Переключаемся на " + choice + " канал");
        System.out.println("Текущий канал у tv2: " + tv2.getChannel());

        System.out.println("");

        System.out.println(tv2.toString());
    }
}
