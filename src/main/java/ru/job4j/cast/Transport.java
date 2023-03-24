package ru.job4j.cast;

public class Transport {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle[] transport = new Vehicle[]{plane, train, bus};
        for (Vehicle tr : transport) {
            tr.move();
            tr.passengers();
            System.out.println();
        }
    }
}
