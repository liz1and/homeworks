package ru.innopolis.java.homework05;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TV [] tvs = new TV[4];
        for (int i = 0; i < tvs.length; i++){
            System.out.print("Включить телевизор? (1 - да, 2 - нет) : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Какой канал включить? ");
                    int channel = sc.nextInt();
                    System.out.print("Введите громкость звука : ");
                    int volume = sc.nextInt();
                    tvs[i] = new TV(true, channel, volume);
                    break;
                case 2:
                    tvs[i] = new TV(false, 0, 0);
                    break;
            }
        }

        for (int i = 0; i < tvs.length - 1; i++) {
            for(int j = 0; j < tvs.length - i - 1; j++) {
                if(tvs[j + 1].getChannel() < tvs[j].getChannel()) {
                    TV swap = tvs[j];
                    tvs[j] = tvs[j + 1];
                    tvs[j + 1] = swap;
                }
            }
        }

        System.out.print("Введите допустимый уровень громкости звука : ");
        int maxVolume = sc.nextInt();

        System.out.println("");

        for (int i = 0; i < tvs.length; i++){
            if ((tvs[i].getVolume() <= maxVolume) && tvs[i].isWorking()){
                System.out.println(tvs[i].toString());
            }
        }
    }
}
