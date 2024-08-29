package ru.innopolis.java.homework010;

import java.util.ArrayList;
import java.util.List;

public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        List<Integer> filteredList = new ArrayList<>();
        for (int num : array) {
            if (condition.isOk(num)) {
                filteredList.add(num);
            }
        }
        return filteredList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
