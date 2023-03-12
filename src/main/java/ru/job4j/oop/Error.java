package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }

    public void printInfo() {
        System.out.println("Состояние: " + active);
        System.out.println("Количество ошибок в программе: " + status);
        System.out.println("Содержание ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error errorWrongName = new Error(true, 3, "Неверное имя пользователя.");
        errorWrongName.printInfo();
        Error errorSymbol = new Error(true, 10, "Недопустимый символ.");
        errorSymbol.printInfo();
    }
}
