package ru.innopolis.java.homework013.test;

import ru.innopolis.java.homework013.utils.ParseToInt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число : ");
        String s = sc.nextLine();
        System.out.println("Результат преобразования с  validateCount: " + ParseToInt.validateCount(s));
        System.out.println("Результат преобразования с  parseCount: " + ParseToInt.parseCount(s));
    }
}
