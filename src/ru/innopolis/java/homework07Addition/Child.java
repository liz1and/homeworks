package ru.innopolis.java.homework07Addition;

import java.util.ArrayList;

public class Child extends Person {

    public Child(String name, int money, int age) {
        super(name, money);
        setAge(age);
    }

    @Override
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Некорректный возраст");
        }
        else if (age >= 0 && age <= 17) {
            super.setAge(age);
        }
        else {
            throw new IllegalArgumentException("Некорректный возраст для ребенка");
        }
    }

    public void addIntoPack(Product product) {
        if (super.getAge() < 6) {
            super.addIntoPack(null);
        }
        else if (product.isAllowedForChildren()) {
            super.addIntoPack(product);
        }
        else {
                throw new IllegalArgumentException("Продукт запрещен для ребенка!");
        }
    }

    public void setPack(ArrayList<Product> pack) {
        if (super.getAge() < 6) {
            super.setPack(null);
        }
        else {
            super.setPack(pack);
        }
    }
}