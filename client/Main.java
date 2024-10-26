package client;

import domain.Bank;
import factory.AccountFactory;
import models.Account;
import models.Customer;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Customer customer1 = new Customer.Builder("John Doe").withAddress("123 Elm Street").build();
        Customer customer2 = new Customer.Builder("Jane Smith").withPhone("555-1234").build();

        Account savings = AccountFactory.createAccount("SAVINGS");
        Account checking = AccountFactory.createAccount("CHECKING");

        bank.addAccount(savings);
        bank.addAccount(checking);
        
        savings.deposit(1000);
        checking.deposit(500);
        
        System.out.println("Savings Balance: " + savings.getBalance());
        System.out.println("Checking Balance: " + checking.getBalance());
    }
}
