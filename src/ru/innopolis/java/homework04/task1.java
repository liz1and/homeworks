package ru.innopolis.java.homework04;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите английскую букву : ");
        char ch = sc.next().charAt(0);
        String words = "qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < words.length(); i++) {
            if (ch == words.charAt(i)) {
                if (i == words.length() - 1 ){
                    System.out.print("Слева на клавиатуре буква : " + words.charAt(0));
                }
                else {
                    System.out.print("Слева на клавиатуре буква : " + words.charAt(i + 1));
                }
            }
        }
    }
}
