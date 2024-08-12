package ru.innopolis.java.homework08;

public class ProductConverter {

    public static Product[] convertFromString(String products) {

        int productsCount = products.length() - products.replace(";", "").length() + 1;
        Product[] productArray = new Product[productsCount];

        for (int i = 0; i < productsCount; i++) {
            productArray[i] = new Product(getName(products), getPrice(products));
            products = products.substring(products.indexOf(";") + 1);
        }
        return productArray;
    }

    public static String getName(String s) {
        s = s.trim();
        if (!s.contains(" =")) {
            return s;
        }
        return s.substring(0, s.indexOf(" ="));
    }

    public static int getPrice(String s) {
        if (s.contains(";")) {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2, s.indexOf(";")));
        } else {
            return Integer.parseInt(s.substring(s.indexOf("= ") + 2));
        }
    }

    public static int getProductIndexByProductName(Product [] productsArray, String productName) {
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getProductName().equals(productName)) {
                return i;
            }
        }
        return -1;
    }
}