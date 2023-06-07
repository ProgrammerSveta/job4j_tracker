package ru.job4j.function;

import java.util.Arrays;
import java.util.Comparator;

public class DeferredExecution {

    public static void main(String[] args) {
        String[] name = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(name, lengthCmp);

        String[] names = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmps = (left, right) -> {
            System.out.println("execute comparator");
            return Integer.compare(left.length(), right.length());
        };
        Arrays.sort(names, lengthCmps);
    }
}
