package utilities.facades;

import domain.factories.AccountFactory;
import domain.models.Account;
import domain.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class BankingFacade {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;

    public Account createAccount(String accountType, Customer customer) {
        Account account = AccountFactory.createAccount(accountType, nextAccountId++);
        accounts.put(account.getId(), account);
        return account;
    }

    public void depositToAccount(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdrawFromAccount(Account account, double amount) {
        account.withdraw(amount);
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }
}
