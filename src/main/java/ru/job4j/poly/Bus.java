package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Транспорт движется");
    }

    @Override
    public void passengers(int people) {
        System.out.println("Количество человек в транспорте: " + people);
    }

    @Override
    public double refuel(double fuel) {
        double price = 4.05;
        return fuel * price;
    }
}
