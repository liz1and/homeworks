package ru.innopolis.java.homework07Addition;

import java.util.ArrayList;
import java.util.Objects;

public class Retiree extends Person{

    public Retiree(String name, int money, int age) {
        super(name, money);
        setAge(age);
    }

    public void setAge(int age) {
        if (age >= 65) {
            super.setAge(age);
        }
        else {
            throw new IllegalArgumentException("Некорректный возраст для пенсионера");
        }
    }

    @Override
    public void addIntoPack(Product product) {
        if (product instanceof DiscountProduct) {
            product.setProductPrice(product.getProductPrice() - product.getProductPrice()*5/100);
            super.addIntoPack(product);
        }
        else {
            throw new IllegalArgumentException("Пенсионер покупает только скидочные товары");
        }
    }

    @Override
    public void setPack(ArrayList<Product> pack) {
        if (Objects.isNull(pack)) {
            throw new NullPointerException("Некорректный набор продуктов");
        }
        else {
            for (Product p : pack) {
                this.addIntoPack(p);
            }
        }
    }
}
