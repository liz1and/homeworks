package ru.innopolis.java.homework014.model;

import java.util.Objects;

public class Product {
    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        if (productName == null || productName.isEmpty()){
            throw new NullPointerException("Имя не может быть пустым");
        }
        else {
            this.productName = productName;
        }
        if (productPrice < 0){
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        else {
            this.productPrice = productPrice;
        }
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.isEmpty()){
            throw new NullPointerException("Имя не может быть пустым");
        }
        else {
            this.productName = productName;
        }
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        if (productPrice < 0){
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        else {
            this.productPrice = productPrice;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productPrice == product.productPrice && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }

    @Override
    public String toString() {
        return productName;
    }
}
