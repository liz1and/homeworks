package ru.innopolis.java.homework07;

import java.util.ArrayList;

public class massCreate {

    public static Product createProduct(String s) {
        return new Product(getName(s),getPrice(s));
    }

    public static DiscountProduct createDiscountProducts(String s) {
        return new DiscountProduct(getName(s),getPrice(s), getDiscount(s));
    }

    public static String getName(String s) {
        if (!s.contains(" =")) {
            return s;
        }
        return s.substring(0, s.indexOf(" ="));
    }

    public static float getPrice(String s) {
        if (s.contains(",")) {
            String p = s.substring(s.indexOf("= ") + 2, s.indexOf(","));
            return Float.parseFloat(p);
        } else {
            return Float.parseFloat(s.substring(s.indexOf("= ") + 2));
        }
    }

    public static int getDiscount(String s) {
        if (s.contains(",")) {
            String d = s.substring(s.indexOf(", ") + 2, s.indexOf("%"));
            return Integer.parseInt(d);
        }
        else {
            return 0;
        }
    }

    public static String printProduct(ArrayList<Product> p) {
        if (!p.isEmpty()) {
            StringBuilder s = new StringBuilder("Обычные продукты: ");
            for (int i = 0; i < p.size(); i++) {
                s.append(p.get(i).getProductName()).append(", ");
            }
            return s.substring(0, s.length() - 2);
        }
        else {
            return "";
        }
    }

    public static String printDiscountProduct(ArrayList<DiscountProduct> p) {
        if (!p.isEmpty()) {
            StringBuilder s = new StringBuilder("Акционные продукты: ");
            for (int i = 0; i < p.size(); i++) {
                s.append(p.get(i).getProductName()).append(", ");
            }
            return s.substring(0, s.length() - 2);
        } else {
            return "";
        }
    }
}