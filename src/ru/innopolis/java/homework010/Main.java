package ru.innopolis.java.homework010;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {12, 23, 25, 36, 38, 549, 556};

        int[] evenNumbers = Sequence.filter(numbers, ByCondition.isEven());
        System.out.println("Четные числа: " + Arrays.toString(evenNumbers));

        int[] numbersWithEvenSumOfDigits = Sequence.filter(numbers, ByCondition.sumOfDigitsIsEven());
        System.out.println("Числа с четной суммой цифр: " + Arrays.toString(numbersWithEvenSumOfDigits));
    }
}
