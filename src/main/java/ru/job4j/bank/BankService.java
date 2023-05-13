package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы со следующими опциями:
 * 1. Создать новый банковский аккаунт.
 * 2. Удалить аккаунт из системы.
 * 3. Добавить аккаунту банковский счет (у аккаунта их может быть несколько).
 * 4. Перевести деньги с одного банковского счета на другой.
 * @author ProgrammerSveta
 * @version 1.0
 */
public class BankService {
    /**
     * В коллекции HashMap хранится вся база данных аккаунтов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет новый аккаунт в БД, если его еще нет.
     * Добавляет аккаунту пустой список ArrayList<Account>,
     * в нём будут храниться банковские счета аккаунта.
     * @param user аккаунт
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет аккаунт из БД.
     * @param passport номер и серия паспорта
     * @return если удаление прошло успешно - true, нет - false
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод добавляет новый банковский счет аккаунту
     * при условии, что такой аккаунт уже есть в системе,
     * а сам счет еще не был добавлен.
     * @param passport серия и номер паспорта
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User find = findByPassport(passport);
        if (find != null) {
            List<Account> user = users.get(find);
            if (!user.contains(account)) {
                user.add(account);
            }
        }
    }

    /**
     * Метод находит аккаунт в БД по серии и номеру паспорта.
     * Если его нет в системе - null.
     * @param passport серия и номер паспорта
     * @return аккаунт
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод находит банковский счет аккаунта по паспорту и реквизитам счета.
     * Если счет не найден - null.
     * @param passport серия и номер паспорта
     * @param requisite реквизиты счета
     * @return банковский счет аккаунта, либо null
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account a : users.get(user)) {
                if (a.getRequisite().equals(requisite)) {
                    rsl = a;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод переводит денеги с одного счета на другой.
     * Если счет не найден или на счете отправителя недостаточно денег,
     * то метод вернет false
     * @param srcPassport серия и номер паспорта аккаунта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport серия и номер паспорта аккаунта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount сумма перевода денег
     * @return если операция прошла успешно - true, нет - false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && amount <= src.getBalance()) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод возвращает список всех счетов аккаунта в виде коллекции ArrayList<Account>
     * @param user аккаунт
     * @return список всех счетов аккаунта в виде коллекции ArrayList<Account>
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}