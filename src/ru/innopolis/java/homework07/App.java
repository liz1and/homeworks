package ru.innopolis.java.homework07;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите названия продуктов, их цены и скидки на них при наличии либо END для завершения");
        String s = sc.nextLine();
        s = s.trim();
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<DiscountProduct> discountProducts = new ArrayList<DiscountProduct>();
        do {
            if (StringUtils.contains(s, "%")) {
                try {
                    discountProducts.add(massCreate.createDiscountProducts(s));
                }
                catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                try {
                    products.add(massCreate.createProduct(s));
                }
                catch (IllegalArgumentException | NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
            s = sc.nextLine();
            s = s.trim();
        } while (!s.equals("END"));

        System.out.println(massCreate.printProduct(products));
        System.out.println(massCreate.printDiscountProduct(discountProducts));
    }
}