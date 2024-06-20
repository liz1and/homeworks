package ru.innopolis.java.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку : ");
        String s = sc.nextLine();
        s = s.replaceAll("\\s","");
        s = s.toLowerCase();
        char [] words = s.toCharArray();
        Arrays.sort(words);
        String sorted = new String(words);
        System.out.print("Отсортированная строка : " + sorted);
    }
}
