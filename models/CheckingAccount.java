package models;

public class CheckingAccount extends Account {
    private double overdraftLimit = 100.0;

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal exceed");
        }
    }
}
