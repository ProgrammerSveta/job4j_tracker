package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит в небе");
    }

    @Override
    public void passengers() {
        System.out.println("Вместимость - 330 пассажиров");
    }
}
