# Creational and Structural Design Patterns in Banking Application

## Author: Ungureanu Vlad

---

## Objectives:
&ensp; &ensp; __1. Study and understand the Behavioral Design Patterns.__

&ensp; &ensp; __2. As a continuation of the previous laboratory work, think about what communication between software entities might be involed in your system.__

&ensp; &ensp; __3. Implement some additional functionalities using behavioral design patterns.__

## Theoretical background:
&ensp; &ensp; In software engineering, behavioral design patterns have the purpose of identifying common communication patterns between different software entities. By doing so, these patterns increase flexibility in carrying out this communication.

&ensp; &ensp; Some examples from this category of design patterns are :

   * Chain of Responsibility
   * Command
   * Interpreter
   * Iterator
   * Mediator
   * Observer
   * Strategy
   
## Main tasks :
&ensp; &ensp; __1. By extending your project, implement at least 1 behavioral design pattern in your project:__
  * The implemented design pattern should help to perform the tasks involved in your system.
  * The behavioral DPs can be integrated into you functionalities alongside the structural ones.
  * There should only be one client for the whole system.
  
&ensp; &ensp; __2. Keep your files grouped (into packages/directories) by their responsibilities (an example project structure):__
  * client;
  * domain;
  * utilities;
  * data(if applies);
  
&ensp; &ensp; __3. Document your work in a separate markdown file according to the requirements presented below (the structure can be extended of course):__
  * Topic of the laboratory work.
  * Author.
  * Introduction/Theory/Motivation.
  * Implementation & Explanation (you can include code snippets as well):
    * Indicate the location of the code snippet.
    * Emphasize the main idea and motivate the usage of the pattern.
  * Results/Screenshots/Conclusions;


## Design Patterns Used:

### Creational Design Patterns
1. **Builder Pattern**: Used to simplify the creation of customer objects, which may have complex attributes.
2. **Factory Pattern**: Used in the AccountFactory class to create different account types (such as SavingsAccount or CheckingAccount) based on input parameters.
3. **Singleton Pattern**: Applied in the BankingFacade to ensure there’s only one point of interaction for the client.

### Structural Design Patterns
1. **Decorator Pattern**: Used to add additional features (such as interest rate bonuses) to accounts without changing their base functionality.
2. **Facade Pattern**: Used in the BankingFacade to simplify the client interface and hide complex operations behind.
3. **Composite Pattern** : Could be used if multiple accounts need to be managed together, like for a customer having several types of accounts.


### Behavioral Design Patterns

1. **Observer Pattern** is a behavioral design pattern in which an object, called the subject, maintains a list of its dependentsand automatically notifies them of any state changes


---

## Implementation & Explanation

### Introduction / Theory 

The project simulates a basic banking application. To manage and simplify operations, we use design patterns that address object creation, encapsulation. Implementing creational patterns improves flexibility in object exmaple, while structural patterns organize functionality.

### Implementation Details


In the context of a banking system, accounts frequently change state (e.g., balance changes due to deposits or withdrawals). The Observer Pattern allows customers to be automatically notified whenever these changes occur without coupling the account's logic with notification mechanisms.  

---

### Where It’s Implemented

#### Core Components:
1. **`Subject.java`**: Manages a list of observers and provides methods for adding, removing, and notifying them.  
2. **`Observer.java`**: Defines the update method to handle notifications.  
3. **`Customer.java`**: Implements Observer` to receive and display notifications.  
4. **`Account.java`**: Inherits from Subject to act as the notifier for state changes.  

---

### Code Snippets

#### Subject Class
The `Subject` class maintains a list of observers and notifies them when the account state changes.

```java
package domain.models;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

```

#### Account Class  
The `Account` class acts as a **subject** and notifies customers of deposits and withdrawals.

```java
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
```

#### Customer Class  
The `Customer` class subscribes to accounts and gets notified of updates.

```java
package domain.models;

public class Customer implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }
}
```

---

### Integrating into the Client

The `BankingFacade` ensures that customers are linked as observers to their accounts. Notifications are sent automatically on deposits and withdrawals.

**`BankingFacade.java`**
```java
package utilities.facades;

import domain.factories.AccountFactory;
import domain.models.Account;
import domain.models.Customer;

import java.util.HashMap;
import java.util.Map;

public class BankingFacade {
    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountId = 1;

    public Account createAccount(String accountType, Customer customer) {
        Account account = AccountFactory.createAccount(accountType, nextAccountId++);
        account.addObserver(customer); 
        accounts.put(account.getId(), account);
        return account;
    }

    public void depositToAccount(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdrawFromAccount(Account account, double amount) {
        account.withdraw(amount);
    }
}
```

---

### Conclusion

The Observer Pattern was effectively integrated into the banking system to enable real-time notifications for customers when account changes occur. By decoupling the account and customer classes, the system became more flexible and maintainable, allowing customers to be notified of updates without tightly coupling them to account operations. This design choice enhances scalability, as adding new observers, such as a mobile app notification service, becomes easy without altering existing logic. 

---