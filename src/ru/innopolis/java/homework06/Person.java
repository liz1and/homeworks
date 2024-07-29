package ru.innopolis.java.homework06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private ArrayList<Product> pack;

    public Person(String name, int money) {
        setName(name);
        setMoney(money);
        this.pack = new ArrayList<Product>();
    }

    public void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("Name cannot be null");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setPack(ArrayList<Product> pack) {
        this.pack = pack;
    }

    public ArrayList<Product> getPack() {
        return this.pack;
    }

    public String getStringPack() {
        String s = "";
        if (Objects.isNull(pack) || (pack.toArray().length <= 0)) {
            return "Ничего не куплено";
        } else {
            for (Product p : pack) {
                s += p.getProductName() + ", ";
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
        return name + " - " +  getStringPack();
    }
}
