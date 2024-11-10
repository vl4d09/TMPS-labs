package utilities.decorators;

import domain.models.Account;

public abstract class AccountDecorator extends Account {
    protected Account account;

    public AccountDecorator(Account account) {
        super(account.getId());
        this.account = account;
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public void deposit(double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}
