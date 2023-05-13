package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет
 * @author ProgrammerSveta
 * @version 1.0
 */
public class Account {
    /**
     * Переменная реквизиты счета
     */
    private String requisite;
    /**
     * Переменная величина баланса денежных средств счета
     */
    private double balance;

    /**
     * Конструктор открытия нового банковского счета
     * @param requisite реквизиты
     * @param balance баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер возвращает реквизиты
     * @return реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер указывает значение переменной реквизиты
     * @param requisite реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер возвращает баланс
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер указывает значение переменной баланс
     * @param balance баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Перепределенный метод equals
     * сравнивает банковские счета по переменной реквизиты
     * @param o объект
     * @return если счета одинаковые - выдает true; если нет - false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределенный метод hashCode
     * сравнивает банковские счета по переменной реквизиты
     * @return если счета одинаковые - выдает true; если нет - false
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}