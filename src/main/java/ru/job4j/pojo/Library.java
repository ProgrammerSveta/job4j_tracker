package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("The only", 100);
        Book bookTwo = new Book("Double", 45);
        Book bookThree = new Book("Trinity", 84);
        Book bookFour = new Book("Clean Code", 25);
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }

        System.out.println("Replace 0 to 3.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            System.out.println(b.getName() + " - " + b.getPages());
        }

        System.out.println("Show only Clean Code book");
        for (int index = 0; index < books.length; index++) {
            Book b = books[index];
            if ("Clean Code".equals(b.getName())) {
                System.out.println(b);
            }
        }
    }
}