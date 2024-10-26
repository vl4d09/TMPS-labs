package factory;

import models.Account;
import models.SavingsAccount;
import models.CheckingAccount;

public class AccountFactory {
    public static Account createAccount(String type) {
        switch (type) {
            case "SAVINGS":
                return new SavingsAccount();
            case "CHECKING":
                return new CheckingAccount();
            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}
