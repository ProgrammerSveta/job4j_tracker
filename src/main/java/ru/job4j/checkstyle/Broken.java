package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    public String name;
    public String surname;
    public static final String NEW_VALUE = "";

    Broken() {
    }

    public void echo() {
    }

    public void media(Object obj) {
        if (obj != null) {
            System.out.println(obj);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {
    }
}