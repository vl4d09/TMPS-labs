package utilities.decorators;

import domain.models.Account;

public class OverdraftProtection extends AccountDecorator {
    private double overdraftLimit;

    public OverdraftProtection(Account account, double overdraftLimit) {
        super(account);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (account.getBalance() + overdraftLimit >= amount) {
            account.withdraw(amount);
        } else {
            System.out.println("Withdrawal denied. Exceeds overdraft limit.");
        }
    }
}
