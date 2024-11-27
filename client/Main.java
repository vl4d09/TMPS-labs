package client;

import domain.models.Account;
import domain.models.Customer;
import utilities.facades.BankingFacade;

public class Main {
    public static void main(String[] args) {
        BankingFacade facade = new BankingFacade();

        Customer john = new Customer("Vlad");
        Account johnsAccount = facade.createAccount("Savings Account", john);

        facade.depositToAccount(johnsAccount, 500);
        facade.withdrawFromAccount(johnsAccount, 200);
        facade.withdrawFromAccount(johnsAccount, 400); 
    }
}
