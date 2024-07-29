package ru.innopolis.java.homework04;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите последовательность : ");
        String s = sc.nextLine();
        int cnt = 0;
        int i = 0;
        int y = 0;
        String s1 = s;
        String s2 = s;
        while (i < s1.length()) {
            if (s1.contains(">>-->")){
                i = s1.indexOf(">>-->") + 5;
                cnt += 1;
                s1 = s1.substring(i);
            }
        }
        while (y < s2.length()) {
            if (s2.contains("<--<<")){
                y = s2.indexOf("<--<<") + 5;
                cnt += 1;
                s2 = s2.substring(y);
            }
        }
        System.out.println("Количество стрел в последовательности : " + cnt);
    }
}
