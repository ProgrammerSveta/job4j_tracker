package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет по рельсам");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость - 540 пассажиров");
    }
}
