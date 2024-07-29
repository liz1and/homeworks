package ru.innopolis.java.homework02;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        System.out.print("Введите число строк и столбцов сетки: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print("Введите повторяемый элемент сетки: ");
        char ch = sc.next().charAt(0);
        System.out.print("Сетка по запросу ");
        System.out.print(n);
        System.out.print(" на ");
        System.out.println(n);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(ch);
            }
            System.out.println("");
        }
    }
}
