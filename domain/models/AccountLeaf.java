package domain.models;

public class AccountLeaf implements AccountComponent {
    private final String accountName;
    private final double balance;

    public AccountLeaf(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Account: " + accountName + ", Balance: " + balance);
    }
}
