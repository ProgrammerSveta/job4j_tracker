package ru.job4j.record;

public record PersonRecord(String name, int age) {
    public static int maxAge = 100;

    public static int getMaxAge() {
        return maxAge;
    }

    public void info() {
        System.out.println("Напечатать информацию");
    }
}