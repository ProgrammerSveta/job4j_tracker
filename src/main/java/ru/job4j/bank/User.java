package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский аккаунт
 * @author ProgrammerSveta
 * @version 1.0
 */
public class User {
    /**
     * Переменная серия и номер паспорта
     */
    private String passport;
    /**
     * Переменная ФИО
     */
    private String username;

    /**
     * Конструктор создания аккаунта
     * @param passport серия и номер паспорта
     * @param username ФИО
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер возвращает серию и номер паспорта
     * @return серия и номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер задает серию и номер паспорта
     * @param passport серия и номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер возвращает ФИО
     * @return ФИО
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер задает ФИО
     * @param username ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределенный метод equals
     * сравнивает два аккаунта по серии и номеру паспорта
     * @param o объект
     * @return если аккаунты одинаковые - true, нет - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределенный метод hashCode
     * сравнивает два аккаунта по серии и номеру паспорта
     * @return если аккаунты одинаковые - true, нет - false
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}