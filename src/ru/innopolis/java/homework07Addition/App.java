package ru.innopolis.java.homework07Addition;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        Product cake = new DiscountProduct("Торт", true, 200, 5);
        Product bread = new Product("Хлеб", true, 40);
        Product tea = new Product("Чай", true, 100);
        Product milk = new Product("Молоко", true, 60);
        Product coffee = new DiscountProduct("Кофе", false, 300, 15);

        try {
            Person child1 = new Child("Егор", 200, 10);
            try {
                child1.addIntoPack(tea);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(child1.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Person child2 = new Child("Аня", 100, 5);
            ArrayList<Product> productsChild = new ArrayList<>();
            productsChild.add(cake);
            productsChild.add(tea);
            try {
                child2.setPack(productsChild);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(child2.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Person man = new Adult("Илья", 1000, 23);
            ArrayList<Product> productsAdult = new ArrayList<>();
            productsAdult.add(milk);
            productsAdult.add(coffee);
            productsAdult.add(bread);
            try {
                man.setPack(productsAdult);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(man.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Person woman = new Adult("Алиса", 2000, 32);
            ArrayList<Product> productsAdult = new ArrayList<>();
            productsAdult.add(milk);
            productsAdult.add(coffee);
            productsAdult.add(bread);
            try {
                woman.setPack(productsAdult);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                try {
                    woman.addIntoPack(cake);
                }
                catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
                finally {
                    System.out.println(woman.toString());
                }
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Person grandma = new Retiree("Елена", 500, 67);
            ArrayList<Product> productsRetiree = new ArrayList<>();
            productsRetiree.add(milk);
            productsRetiree.add(coffee);
            try {
                grandma.setPack(productsRetiree);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(grandma.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        try {
            Person grandpa = new Retiree("Андрей", 650, 75);
            try {
                grandpa.addIntoPack(cake);
            }
            catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println(grandpa.toString());
            }
        }
        catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
