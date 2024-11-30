package ru.innopolis.java.homework014.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class PersonTest {

    @Test
    @DisplayName("Создание Person с корректными данными")
    void createPersonWithValidData() {
        String name = "John Doe";
        int money = 1000;
        Person person = new Person(name, money);

        Assertions.assertNotNull(person);
        Assertions.assertEquals(name, person.getName());
        Assertions.assertEquals(money, person.getMoney());
        Assertions.assertEquals(new ArrayList<>(), person.getPack());
    }

    @ParameterizedTest
    @MethodSource("invalidPersonData")
    @DisplayName("Создание Person с некорректными данными")
    void createPersonWithInvalidData(String name, int money, Class<? extends Throwable> expectedExceptionClass) {
        Assertions.assertThrows(expectedExceptionClass, () -> new Person(name, money));
    }

    static Stream<Arguments> invalidPersonData() {
        return Stream.of(
                Arguments.of(null, 1000, NullPointerException.class),
                Arguments.of("John Doe", -100, IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("Добавление продукта в корзину")
    void addProductToPack() {
        Person person = new Person("John Doe", 1000);
        Product product = new Product("Apple", 10);

        Assertions.assertTrue(person.addProductToPack(product));
        Assertions.assertEquals(1, person.getPack().size());
        Assertions.assertEquals(990, person.getMoney());
    }

    @ParameterizedTest
    @MethodSource("productsWithValidAndInvalidPrices")
    @DisplayName("Добавление продуктов в корзину с различными ценами")
    @Disabled("Этот тест временно отключен")
    void addProductsWithValidAndInvalidPrices(int money, List<Product> products, boolean expectedResult) {
        Person person = new Person("John Doe", money);

        for (Product product : products) {
            Assertions.assertEquals(expectedResult, person.addProductToPack(product));
        }
    }

    static Stream<Arguments> productsWithValidAndInvalidPrices() {
        List<Product> validProducts = new ArrayList<>();
        validProducts.add(new Product("Apple", 10));
        validProducts.add(new Product("Banana", 20));

        List<Product> invalidProducts = new ArrayList<>();
        invalidProducts.add(new Product("Apple", 10));
        invalidProducts.add(new Product("Banana", 1000));

        return Stream.of(
                Arguments.of(100, validProducts, true),
                Arguments.of(100, invalidProducts, false)
        );
    }

    @Test
    @DisplayName("Установка отрицательной суммы денег")
    void setNegativeMoneyValue() {
        Person person = new Person("John Doe", 1000);
        Assertions.assertThrows(IllegalArgumentException.class, () -> person.setMoney(-100));
    }

    @Test
    @DisplayName("Установка null в качестве имени")
    void setNullName() {
        Person person = new Person("John Doe", 1000);
        Assertions.assertThrows(NullPointerException.class, () -> person.setName(null));
    }
}