package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftNumber = left.split("\\.");
        String[] rightNumber = right.split("\\.");
        int n1 = Integer.parseInt(leftNumber[0]);
        int n2 = Integer.parseInt(rightNumber[0]);
        return Integer.compare(n1, n2);
    }
}