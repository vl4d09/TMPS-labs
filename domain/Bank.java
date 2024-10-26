package domain;

import models.Account;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank instance;
    private List<Account> accounts = new ArrayList<>();

    private Bank() {}

    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
