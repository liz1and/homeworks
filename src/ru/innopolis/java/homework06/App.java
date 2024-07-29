package ru.innopolis.java.homework06;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имена покупателей и суммы денег у них");
        String persons = sc.nextLine();

        try {Person [] personsArray = massCreate.createPersons(persons);
            System.out.println("Введите наименования продуктов и их стоимость");
            String products = sc.nextLine();
            Product [] productsArray = massCreate.createProducts(products);

            System.out.println("Введите имя покупателя и выбранный продукт либо END для завершения");
            String s = sc.nextLine();
            s = s.trim();
            while (!s.equals("END")) {
                String name = s.substring(0, s.lastIndexOf(" "));
                int idPerson = massCreate.getPersons(personsArray, name);
                String productName = s.substring(s.lastIndexOf(" ") + 1);
                int idProduct = massCreate.getProducts(productsArray, productName);
                if (personsArray[idPerson].getMoney() >= productsArray[idProduct].getProductPrice()) {
                    ArrayList<Product> pack = personsArray[idPerson].getPack();
                    pack.add(productsArray[idProduct]);
                    personsArray[idPerson].setPack(pack);
                    personsArray[idPerson].setMoney(personsArray[idPerson].getMoney() - productsArray[idProduct].getProductPrice());
                    System.out.println(personsArray[idPerson].getName() + " купил(а) " + productsArray[idProduct].getProductName());
                }
                else {
                    System.out.println(personsArray[idPerson].getName() + " не может позволить себе " + productsArray[idProduct].getProductName());
                }
                System.out.println("Введите имя покупателя и выбранный продукт либо END для завершения");
                s = sc.nextLine();
                s = s.trim();
            }

            for (int i = 0; i < personsArray.length; i++) {
                System.out.println(personsArray[i].toString());
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
