package ru.innopolis.java.homework01;

import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        System.out.println("Камень - 0, ножницы - 1, бумага - 2");
        Random r = new Random();
        int a = r.nextInt(3);
        int b = r.nextInt(3);
        System.out.print("Вася выбрал : ");
        System.out.println(a);
        System.out.print("Петя выбрал : ");
        System.out.println(b);
        if (a == b) {
            System.out.println("Ничья");
        }
        else if (a == 2 && b == 0 || a == 0 && b == 1 || a == 1 && b == 2) {
            System.out.println("Вася победил");
        }
        else if (b == 2 && a == 0 || b == 0 && a == 1 || b == 1 && a == 2) {
            System.out.println("Петя победил");
        }
        else {
            System.out.println("Введены некорректные значения!");
        }
    }
}
