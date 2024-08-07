package ru.innopolis.java.homework06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private List<Product> pack;

    public Person(String name, int money) {
        if (Objects.isNull(name)) {
            throw new NullPointerException("Name cannot be null");
        } else {
            this.name = name;
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        } else {
            this.money = money;
        }
        this.pack = new ArrayList<>();
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

    public void setPack(List<Product> pack) {
        this.pack = pack;
    }

    public List<Product> getPack() {
        return this.pack;
    }

    public boolean addProductToPack(Product product) {
        if (this.getMoney() >= product.getProductPrice()){
            this.pack.add(product);
            this.setMoney(this.getMoney() - product.getProductPrice());
            return true;
        }
        else{
            return false;
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
        StringBuilder s = new StringBuilder();
        s.append(this.name);
        s.append(" - ");
        if (pack.isEmpty()) {
            s.append("Ничего не куплено");
        }
        else {
            s.append(pack.toString(), 1, pack.toString().length() - 1);
        }
        return s.toString();
    }
}
