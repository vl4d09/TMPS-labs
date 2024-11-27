package domain.models;

import java.util.ArrayList;
import java.util.List;

public class Account implements Subject {
    private int id;
    private double balance;
    private List<Observer> observers = new ArrayList<>();

    public Account(int id) {
        this.id = id;
        this.balance = 0.0; 
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        notifyObservers("Deposit of " + amount + " completed. New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            notifyObservers("Withdrawal of " + amount + " completed. New balance: " + balance);
        } else {
            notifyObservers("Withdrawal of " + amount + " failed. Insufficient funds.");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
