package ru.innopolis.java.homework07;

import java.util.Objects;

public class DiscountProduct extends Product{
    private int discount;

    public DiscountProduct(String productName, float price, int discount) {
        super(productName);
        setDiscount(discount);
        price = price - price * discount / 100;
        super.setProductPrice(price);
    }

    public int getDiscount() { return discount; }

    public void setDiscount(int discount) {
        if (Objects.isNull(discount)) {
            throw new IllegalArgumentException("Некорректная скидка!");
        } else {
            if (this.discount == 0 || Objects.isNull(this.discount) ) {
                if (this.getProductPrice() != 0) {
                    float price = this.getProductPrice();
                    this.setProductPrice(price - price * discount / 100);
                    this.discount = discount;
                }
                else {
                    this.discount = discount;
                }
            }
            else {
                float price = this.getProductPrice();
                price = 100 * price / ( 100 - this.discount);
                this.setProductPrice(price - price * discount / 100);
                this.discount = discount;
            }
        }
    }
}