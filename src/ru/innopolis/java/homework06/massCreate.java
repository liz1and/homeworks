package ru.innopolis.java.homework06;

public class massCreate {

    public static Product[] createProducts(String products) {

        int productsCount = products.length() - products.replace(";", "").length() + 1;
        Product[] productArray = new Product[productsCount];

        for (int i = 0; i < productsCount; i++) {
            productArray[i] = new Product(getName(products), getMoney(products));
            products = products.substring(products.indexOf(";") + 1);
        }
        return productArray;
    }

    public static Person [] createPersons(String persons) {

        int personsCount = persons.length() - persons.replace(";", "").length() + 1;
        Person [] personArray = new Person[personsCount];

        for (int i = 0; i < personsCount; i++) {
            personArray[i] = new Person(getName(persons), getMoney(persons));
            persons = persons.substring(persons.indexOf(";") + 1);
        }
        return personArray;
    }

    public static String getName(String s) {
        s = s.trim();
        if (s.indexOf(" =") == -1) {
            return s;
        }
        return s.substring(0, s.indexOf(" ="));
    }

    public static int getMoney(String s) {
        if (s.indexOf(";") != -1) {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2, s.indexOf(";")));
        } else {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2));
        }
    }

    public static int getPersons(Person [] personsArray, String name) {
        for (int i = 0; i < personsArray.length; i++) {
            if (personsArray[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int getProducts(Product [] productsArray, String productName) {
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getProductName().equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}
