package domain.factories;

import domain.models.Account;
import domain.models.SavingsAccount;
import domain.models.CheckingAccount;

public class AccountFactory {
    public static Account createAccount(String accountType, int id) {
        if (accountType.equalsIgnoreCase("savings")) {
            return new SavingsAccount(id);
        } else if (accountType.equalsIgnoreCase("checking")) {
            return new CheckingAccount(id);
        }
        return null;
    }
}
