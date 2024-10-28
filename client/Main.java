package client;

import domain.Bank;
import factory.AccountFactory;
import models.Account;
import models.Customer;

public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        Customer customer1 = new Customer.Builder("Vlad").withAddress("123 grove street").build();
        Customer customer2 = new Customer.Builder("Marius").withPhone("026899999").build();

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
