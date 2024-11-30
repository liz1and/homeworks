package ru.innopolis.java.homework014.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ProductTest {

    @Test
    @DisplayName("Создание Product с корректными данными")
    void createProductWithValidData() {
        String name = "Apple";
        int price = 10;
        Product product = new Product(name, price);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(name, product.getProductName());
        Assertions.assertEquals(price, product.getProductPrice());
    }

    @ParameterizedTest
    @MethodSource("invalidProductData")
    @DisplayName("Создание Product с некорректными данными")
    void createProductWithInvalidData(String name, int price, Class<? extends Throwable> expectedExceptionClass) {
        Assertions.assertThrows(expectedExceptionClass, () -> new Product(name, price));
    }

    static Stream<Arguments> invalidProductData() {
        return Stream.of(
                Arguments.of(null, 10, NullPointerException.class),
                Arguments.of("", 10, NullPointerException.class),
                Arguments.of("Apple", -5, IllegalArgumentException.class)
        );
    }

}