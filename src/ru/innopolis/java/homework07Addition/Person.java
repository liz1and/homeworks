package ru.innopolis.java.homework07Addition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private float money;
    private int age;
    private ArrayList<Product> pack = new ArrayList<>();

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.pack = new ArrayList<>();
    }

    public void setAge(int age) { this.age = age; }

    public int getAge() { return this.age; }

    public void setMoney(float money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
    }

    public float getMoney() { return money; }

    public void setName(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("Некорректное имя");
        } else {
            this.name = name;
        }
    }

    public String getName() { return name;}

    public void addIntoPack(Product product) {
         if (this.getMoney() >= product.getProductPrice() ) {
            this.pack.add(product);
            this.setMoney((this.getMoney() - product.getProductPrice()));
        }
        else {
            throw new IllegalArgumentException("Стоимость больше, чем сумма денег у покупателя");
        }
    }

    public void setPack(ArrayList<Product> pack) {
        if (Objects.isNull(pack)) {
            this.pack = null;
        }
        else {
            for (Product p : pack) {
                this.addIntoPack(p);
            }
        }
    }

    public ArrayList<Product> getPack() { return this.pack; }

    public String getStringPack() {
        StringBuilder s = new StringBuilder();
        if (Objects.isNull(pack) || (pack.toArray().length == 0)) {
            return "Ничего не куплено";
        } else {
            for (Product p : pack) {
                s.append(p.getProductName()).append(", ");
            }
            return s.substring(0, s.length() - 2);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return money == person.money && Objects.equals(name, person.name) && Objects.deepEquals(pack, person.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, Arrays.hashCode(pack.toArray()));
    }

    @Override
    public String toString() {
        return getName() + " " + getAge() + " - " +  getStringPack();
    }
}