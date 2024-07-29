package ru.innopolis.java.homework02;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        System.out.print("Введите первое целое число: ");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.print("Введите второе целое число: ");
        int b = sc.nextInt();
        System.out.print("Сумма двух целых чисел: ");
        System.out.println(a+b);
        System.out.print("Разница двух целых чисел: ");
        System.out.println(a-b);
        System.out.print("Произведение из двух целых чисел: ");
        System.out.println(a*b);
        System.out.print("Среднее из двух целых чисел: ");
        System.out.println((float)(a+b)/2);
        System.out.print("Расстояние двух целых чисел: ");
        System.out.println(Math.abs(b-a));
        System.out.print("Максимальное целое число: ");
        System.out.println(Math.max(a,b));
        System.out.print("Минимальное целое число: ");
        System.out.println(Math.min(a,b));
    }
}
