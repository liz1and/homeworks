package ru.innopolis.java.homework07Addition;

import java.util.ArrayList;
import java.util.Objects;

public class Adult extends Person {

    private float credit = 0;

    public Adult(String name, int money, int age) {
        super(name, money);
        setAge(age);
    }

    @Override
    public void setAge(int age) {
        if (age >= 18 && age < 65) {
            super.setAge(age);
        }
        else {
            throw new IllegalArgumentException("Некорректный возраст для взрослого");
        }
    }

    public void setCredit(float credit) { this.credit = credit; }

    public float getCredit() { return credit; }

    //ПОКУПАТЬ В КРЕДИТ?

    @Override
    public void addIntoPack(Product product) {
        if (Objects.isNull(product)) {
            throw new NullPointerException("Некорректный продукт");
        }
        else if (this.getMoney() >= product.getProductPrice() ) {
            super.addIntoPack(product);
            this.setMoney((this.getMoney() - product.getProductPrice()));
        }
        else if (this.getMoney() < product.getProductPrice()) {
            float diff = this.getMoney() - product.getProductPrice();
            this.setCredit(diff);
            this.setMoney(diff);
            super.addIntoPack(product);
        }
        else {
            throw new IllegalArgumentException("Стоимость больше, чем сумма денег у покупателя");
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


    @Override
    public String toString() {
        if (getCredit() > 0) {
            return super.getName() + " " + super.getAge() + " - " + getStringPack() + " кредит :" + getCredit();
        }
        else {
            return super.getName() + " " + super.getAge() + " - " + getStringPack();
        }
    }
}
