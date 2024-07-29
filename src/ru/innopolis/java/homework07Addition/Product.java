package ru.innopolis.java.homework07Addition;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Product {
    private String productName;
    private float productPrice;
    private boolean isAllowedForChildren;

    public Product(String productName, boolean isAllowedForChildren) { setProductName(productName); setAllowedForChildren(isAllowedForChildren);}

    public Product(String productName, boolean isAllowedForChildren, float productPrice) {
        setProductName(productName);
        setProductPrice(productPrice);
        setAllowedForChildren(isAllowedForChildren);
    }
    public String getProductName() { return productName;}

    public void setProductName(String productName) {
        if (productName == null || productName.isEmpty()){
            throw new NullPointerException("Недопустимое имя продукта!");
        }
        else {
            if (productName.length() < 3){
                throw new IllegalArgumentException("Недопустимое имя продукта!");
            }
            else{
                if (StringUtils.isNumeric(productName)){
                    throw new IllegalArgumentException("Недопустимое имя продукта!");
                }
                else {
                    this.productName = productName;
                }
            }
        }
    }

    public float getProductPrice() { return productPrice; }

    public void setProductPrice(float productPrice) {
        if (productPrice > 0){
            this.productPrice = productPrice;
        }
        else {
            throw new IllegalArgumentException("Недопустимая стоимость продукта!");
        }
    }

    public boolean isAllowedForChildren() { return isAllowedForChildren; }

    public void setAllowedForChildren(boolean allowedForChildren) {
        this.isAllowedForChildren = allowedForChildren;
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
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}