package domain.factories;

import domain.models.Account;
import domain.models.CheckingAccount;
import domain.models.SavingsAccount;

public class AccountFactory {
    public static Account createAccount(String accountType, int id) {
        if ("Checking".equalsIgnoreCase(accountType) || "Checking Account".equalsIgnoreCase(accountType)) {
            return new CheckingAccount(id);
        } else if ("Savings".equalsIgnoreCase(accountType) || "Savings Account".equalsIgnoreCase(accountType)) {
            return new SavingsAccount(id);
        } else {
            throw new IllegalArgumentException("Invalid account type: " + accountType);
        }
    }
}
