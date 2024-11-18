package utilities.facades;

import domain.factories.AccountFactory;
import domain.models.Account;
import domain.models.Customer;
import domain.models.AccountComposite;
import domain.models.AccountLeaf;

import java.util.HashMap;
import java.util.Map;

public class BankingFacade {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;
    private AccountComposite portfolio = new AccountComposite("Customer Portfolio");

    public Account createAccount(String accountType, Customer customer) {
        Account account = AccountFactory.createAccount(accountType, nextAccountId++);
        accounts.put(account.getId(), account);
        

        portfolio.addAccount(new AccountLeaf(accountType + " (" + account.getId() + ")", account.getBalance()));
        return account;
    }

    public void depositToAccount(Account account, double amount) {
        account.deposit(amount);
        updatePortfolio(account);
    }

    public void withdrawFromAccount(Account account, double amount) {
        account.withdraw(amount);
        updatePortfolio(account);
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }

    public void displayPortfolio() {
        portfolio.displayAccountDetails();
    }

    private void updatePortfolio(Account account) {
        portfolio.addAccount(new AccountLeaf("Updated Account " + account.getId(), account.getBalance()));
    }
}
