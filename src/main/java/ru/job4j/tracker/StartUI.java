package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime currentDateTime = item.getCreated();
        String date = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + date);

        Item item2 = new Item(2, "Sveta");
        System.out.println("User: "
                + item2.getId() + " "
                + item2.getName() + " "
                + item2.getCreated()
        );
    }
}