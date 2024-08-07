package ru.innopolis.java.homework06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имена покупателей и суммы денег у них");
        String persons = sc.nextLine();

        try {Person [] personsArray = PersonConverter.convertFromString(persons);
            System.out.println("Введите наименования продуктов и их стоимость");
            String products = sc.nextLine();
            Product [] productsArray = ProductConverter.convertFromString(products);

            System.out.println("Введите имя покупателя и выбранный продукт либо END для завершения");
            String s = sc.nextLine();
            s = s.trim();
            while (!s.equals("END")) {
                String name = s.substring(0, s.lastIndexOf(" "));
                int idPerson = PersonConverter.getPersonIndexByName(personsArray, name);
                String productName = s.substring(s.lastIndexOf(" ") + 1);
                int idProduct = ProductConverter.getProductIndexByProductName(productsArray, productName);
                if (personsArray[idPerson].addProductToPack(productsArray[idProduct])) {
                    System.out.println(personsArray[idPerson].getName() + " купил(а) " + productsArray[idProduct].getProductName());
                }
                else {
                    System.out.println(personsArray[idPerson].getName() + " не может позволить себе " + productsArray[idProduct].getProductName());
                }
                System.out.println("Введите имя покупателя и выбранный продукт либо END для завершения");
                s = sc.nextLine();
                s = s.trim();
            }

            for (Person person : personsArray) {
                System.out.println(person.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
