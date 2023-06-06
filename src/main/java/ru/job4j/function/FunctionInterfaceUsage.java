package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());

        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup2 = () -> new HashSet<>(list);
        Set<String> strings = sup2.get();
        for (String s : strings) {
            System.out.println(s);
        }

        Supplier<String> sup3 = () -> "New String For Interface";
        BiConsumer<String, String> consumer = (s, s1) -> System.out.println(s + s1);
        consumer.accept(sup3.get(), " and Second String");
    }
}