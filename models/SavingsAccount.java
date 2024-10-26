package models;

public class SavingsAccount extends Account {
    private double interestRate = 0.02;

    public void applyInterest() {
        balance += balance * interestRate;
    }
}
