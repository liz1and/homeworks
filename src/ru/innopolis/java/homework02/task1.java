package ru.innopolis.java.homework02;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите степень в градусах Фаренгейта: ");
        Scanner sc = new Scanner(System.in);
        float f = sc.nextFloat();
        double c = 5.0/9.0 * (f - 32);
        System.out.print(f);
        System.out.print(" градусов по Фаренгейту равно ");
        System.out.print(c);
        System.out.print(" по Цельсию");
    }
}
