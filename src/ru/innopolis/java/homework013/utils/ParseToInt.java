package ru.innopolis.java.homework013.utils;

public class ParseToInt {

    public static int parseCount (String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    public static int validateCount(Object value) {
        if (value instanceof String) {
            try {
                return parseCount((String) value);
            } catch (IllegalArgumentException e) {
                return -1;
            }
        } else if (value instanceof Integer) {
            return (int) value;
        } else {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }
}
