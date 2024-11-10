package domain.models;

public abstract class Account {
    private int id;
    private double balance;

    public Account(int id) {
        this.id = id;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
