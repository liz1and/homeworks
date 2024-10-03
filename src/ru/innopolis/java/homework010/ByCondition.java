package ru.innopolis.java.homework010;

@FunctionalInterface
public interface ByCondition  {

    boolean isOk(int number);

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