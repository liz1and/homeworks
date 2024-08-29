package ru.innopolis.java.homework010;

import java.util.function.IntPredicate;

@FunctionalInterface
public interface ByCondition extends IntPredicate {

    boolean isOk(int number);

    @Override
    default boolean test(int value) {
        return false;
    }

    static ByCondition isEven() {
        return n -> n % 2 == 0;
    }

    static ByCondition sumOfDigitsIsEven() {
        return n -> {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum % 2 == 0;
        };
    }
}