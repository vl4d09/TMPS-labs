package domain.models;

import java.util.ArrayList;
import java.util.List;

public class AccountComposite implements AccountComponent {
    private final String groupName;
    private final List<AccountComponent> accounts = new ArrayList<>();

    public AccountComposite(String groupName) {
        this.groupName = groupName;
    }

    public void addAccount(AccountComponent account) {
        accounts.add(account);
    }

    public void removeAccount(AccountComponent account) {
        accounts.remove(account);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Group: " + groupName);
        for (AccountComponent account : accounts) {
            account.displayAccountDetails();
        }
    }
}
