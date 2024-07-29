package ru.innopolis.java.homework02;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        System.out.print("Исходная строка: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print("Сколько раз вывести строку? ");
        int n = sc.nextInt();
        System.out.print("После повторения ");
        System.out.print(n);
        System.out.print(" раз: ");
        System.out.print(s.repeat(n));
    }
}
