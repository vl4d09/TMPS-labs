package client;

import domain.models.Customer;
import domain.models.Account;
import utilities.facades.BankingFacade;
import utilities.decorators.InterestRateBonus;
import utilities.decorators.OverdraftProtection;

public class Main {
    public static void main(String[] args) {
        BankingFacade facade = new BankingFacade();

        Customer customer1 = new Customer.Builder("Alice")
                .address("123 Main St")
                .phone("555-1234")
                .build();

        Account savingsAccount = facade.createAccount("savings", customer1);
        facade.depositToAccount(savingsAccount, 500);

        OverdraftProtection protectedAccount = new OverdraftProtection(savingsAccount, 100);
        protectedAccount.withdraw(550);

        InterestRateBonus bonusAccount = new InterestRateBonus(savingsAccount, 0.05);
        bonusAccount.applyBonus();

        System.out.println("Final Balance with Overdraft and Bonus: " + bonusAccount.getBalance());
    }
}
