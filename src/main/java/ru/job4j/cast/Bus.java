package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус едет по шоссе");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость - 40 пассажиров");
    }
}
