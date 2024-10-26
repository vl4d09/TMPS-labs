
---

# Creational Design Pattern

### Overview
In this project, I developed a simple banking system in Java that applies three essential creational design patterns: Singleton, Factory, and Builder. The objective was to incorporate these patterns in a way that feels practical and relevant, showing how they make the code more modular and maintainable in a real-world scenario.

### Project Structure

The project is organized into four main packages based on their responsibilities: `client`, `domain`, `factory`, and `models`. The `client` package contains the main program that initializes and tests the system. The `domain` package has the `Bank` class, which is responsible for managing accounts and follows the Singleton pattern. The `factory` package includes the `AccountFactory`, which handles the creation of accounts, following the Factory pattern. Finally, the `models` package contains the main data models, `Account` and `Customer`, with the `Customer` class implementing the Builder pattern.


### Implementation 

#### Singleton Pattern
The Singleton pattern is applied in the `Bank` class, which ensures that only a single instance of `Bank` exists through the application. This instance is accessed by a static `getInstance` method. Here’s the code 


```java
package domain;

import models.Account;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank instance;
    private List<Account> accounts = new ArrayList<>();

    private Bank() {}

    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
```

The Singleton pattern here makes sure that all account-related operations are managed centrally by one `Bank` instance. This way, data consistency is maintained across the application, as all accounts are stored in a single list.

#### Factory Pattern 
The Factory pattern is implemented in the `AccountFactory` class, which provides a method for creating `Account` objects. By using a factory for account creation, the code remains clean and avoids repetitive instantiation logic.

```java
package factory;

import models.Account;
import models.SavingsAccount;
import models.CheckingAccount;

public class AccountFactory {
    public static Account createAccount(String type) {
        switch (type) {
            case "SAVINGS":
                return new SavingsAccount();
            case "CHECKING":
                return new CheckingAccount();
            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }
}

```

The Factory pattern allows for future modifications if additional account types need to be introduced. Instead of modifying every place where `Account` objects are created, one would only need to adjust the `AccountFactory` class, making it an easily solution.

#### Builder Pattern 
The Builder pattern is used in the `Customer` class to create customer objects with optional fields, such as address and phone number. This pattern makes object creation flexible, especially when objects have optional attributes.

```java
package models;

public class Customer {
    private String name;
    private String address;
    private String phone;

    private Customer(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }

    public static class Builder {
        private String name;
        private String address;
        private String phone;

        public Builder(String name) {
            this.name = name;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
```

With the Builder pattern, creating `Customer` objects is straightforward and adaptable. Only the `name` field is required, while other fields like `address` and `phone` can be added as needed, making the `Customer` class much easier to work with, especially when some fields are optional.

### Testing the Project 
In the `Main` class, the application is tested by creating a `Customer`, generating an `Account`, and performing a simple deposit operation. Here is the code 

```java
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

```

In this `Main` program, I first retrieve the singleton instance of `Bank`. Then, I create a `Customer` with only a name and optional address using the Builder pattern, demonstrating the flexibility of the Builder. Using the Factory, an `Account` is created and added to the bank. Finally, a deposit is made to verify that the account balance updates correctly.

### Summary
In this project, I applied three creational patterns to implement a simple yet functional banking system. The Singleton pattern is used to manage a single instance of the `Bank` class, ensuring consistent account management. The Factory pattern simplifies the creation of `Account` objects, while the Builder pattern offers a flexible way to create `Customer` objects.