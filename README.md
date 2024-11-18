# Creational and Structural Design Patterns in Banking Application

## Author: Ungureanu Vlad

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Structural Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.__

&ensp; &ensp; __3. Implement some additional functionalities using structural design patterns.__

## Theoretical background:
&ensp; &ensp; In software engineering, the Structural Design Patterns are concerned with how classes and objects are composed to form larger structures. Structural class patterns use inheritance to create a hierarchy of classes/abstractions, but the structural object patterns use composition which is generally a more flexible alternative to inheritance.

&ensp; &ensp; Some examples of from this category of design patterns are:

   * Adapter
   * Bridge
   * Composite
   * Decorator
   * Facade
   * Flyweight
   * Proxy

## Design Patterns Used:

### Creational Design Patterns
1. **Builder Pattern**: Used to simplify the creation of customer objects, which may have complex attributes.
2. **Factory Pattern**: Used in the AccountFactory class to create different account types (such as SavingsAccount or CheckingAccount) based on input parameters.
3. **Singleton Pattern**: Applied in the BankingFacade to ensure there’s only one point of interaction for the client.

### Structural Design Patterns
1. **Decorator Pattern**: Used to add additional features (such as interest rate bonuses) to accounts without changing their base functionality.
2. **Facade Pattern**: Used in the BankingFacade to simplify the client interface and hide complex operations behind.
3. **Composite Pattern** : Could be used if multiple accounts need to be managed together, like for a customer having several types of accounts.

---

## Implementation & Explanation

### Introduction / Theory 

The project simulates a basic banking application. To manage and simplify operations, we use design patterns that address object creation, encapsulation. Implementing creational patterns improves flexibility in object exmaple, while structural patterns organize functionality.

### Implementation Details

### 1. **Builder Pattern** 

The **Builder Pattern** helps in creating complex objects with multiple optional parts. 
In our case, we use the builder pattern to create a customer object. Instead of forcing the client to pass a lot of parameters to the constructor, the builder allows the client to set only the necessary attributes.


```java
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.phone = builder.phone;
    }
}
```



### 2. **Factory Pattern** 

The **Factory Pattern** centralizes object creation into a single class, making it easier to manage different object types. In our system, the factory is responsible for creating accounts (savingsaccount, checkingaccount), that the correct type of account is created based on the client's request.


```java
public class AccountFactory {
    public Account createAccount(String type) {
        if (type.equalsIgnoreCase("SAVINGS")) {
            return new SavingsAccount();
        } else if (type.equalsIgnoreCase("CHECKING")) {
            return new CheckingAccount();
        }
        throw new IllegalArgumentException("Unknown account type");
    }
}
```

### 3. **Singleton Pattern** 

The **Singleton Pattern** ensures that only one instance of a class exists in the system. It is particularly useful like in our case, a bankingfacade, which acts as a single entry point for all banking operations.



```java
public class BankingFacade {
    private static BankingFacade instance;

    private BankingFacade() {}

    public static BankingFacade getInstance() {
        if (instance == null) {
            instance = new BankingFacade();
        }
        return instance;
    }

    public Account createAccount(String type) {
        return new AccountFactory().createAccount(type);
    }
}
```



### 4. **Decorator Pattern** 

The **Decorator Pattern** allows us to add additional responsibilities to an object dynamically, without modifying its original class. In this project, we use it to enhance the Account class by adding features like OverdraftProtection and InterestRateBonus.



```java
public class OverdraftProtection extends AccountDecorator {
    public OverdraftProtection(Account account) {
        super(account);
    }

    @Override
    public void performOperation() {
        super.performOperation();
        System.out.println("Overdraft protection enabled.");
    }
}
```

### 5. **Facade Pattern** 

The **Facade Pattern** provides a simplified interface to a set of interfaces in a subsystem, hiding the complexity of account creation and feature addition from the client.

```java

public class BankingFacade {
    private AccountComposite portfolio = new AccountComposite("Customer Portfolio");

    public Account createAccount(String accountType, Customer customer) {
        Account account = AccountFactory.createAccount(accountType, nextAccountId++);
        portfolio.addAccount(new AccountLeaf(accountType + " (" + account.getId() + ")", account.getBalance()));
        return account;
    }

    public void displayPortfolio() {
        portfolio.displayAccountDetails();
    }
}

```
### 6. Composite Pattern

The **Composite Pattern** was integrated into the BankingFacade to manage both individual accounts and groups of accounts, such as a "Portfolio." This allows treating single accounts and account collections the same way, simplifying operations like displaying balances or managing multiple accounts.

#### **Code Snippet**

**`AccountComposite` and `AccountLeaf`:**
```java
public class AccountComposite implements AccountComponent {
    private List<AccountComponent> accounts = new ArrayList<>();

    public void addAccount(AccountComponent account) {
        accounts.add(account);
    }

    public void displayAccountDetails() {
        for (AccountComponent account : accounts) {
            account.displayAccountDetails();
        }
    }
}

public class AccountLeaf implements AccountComponent {
    private String name;
    private double balance;

    public AccountLeaf(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account: " + name + ", Balance: " + balance);
    }
}
```

Here, AccountComposite acts as a group, while AccountLeaf represents an individual account. These classes work together to form the composite structure, which the bankingfacade manages transparently.


---

### Conclusion

Using design patterns like Builder, Factory, Singleton, Decorator, Composite and Facade has made the banking system more organized and easier to maintain. These patterns helped simplify complex tasks, centralize object creation, and allow for easy feature extensions without changing core logic. Overall, they’ve made the system more flexible, maintainable, and scalable for future updates.structure.

---