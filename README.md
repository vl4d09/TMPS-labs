# Student: Ungureanu Vlad
# Group: FAF-223
# SOLID Principles in Java: SRP and OCP Implementation

## 1. Single Responsibility Principle (SRP)

### Overview
The **Single Responsibility Principle (SRP)** states that a class should have one, and only one, reason to change. In other words, a class should only have one responsibility or job. This principle encourages separation of concerns, making your code more modular and easier to maintain.

### Implementation

For the SRP implementation, we created three distinct classes:
1. **`User`**: Holds user-related data (name and email).
2. **`EmailService`**: Responsible for sending emails to users.
3. **`UserRepository`**: Responsible for saving users to the database.

Each class has a single responsibility:
- The `User` class manages only the user's attributes (data).
- The `EmailService` class manages the sending of emails.
- The `UserRepository` class manages database-related operations (such as saving the user).

This separation of responsibilities ensures that changes to one class (e.g., modifying how emails are sent) won’t affect the other classes (like user data or database operations).

### Code Example

```java
// User.java - Manages user data
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// EmailService.java - Responsible for sending emails
public class EmailService {
    public void sendEmail(User user, String message) {
        // Simulate sending an email
        System.out.println("Sending email to " + user.getEmail() + ": " + message);
    }
}

// UserRepository.java - Responsible for database operations
public class UserRepository {
    public void save(User user) {
        // Simulate saving to a database
        System.out.println("Saving " + user.getName() + " to the database.");
    }
}

// Main.java - Entry point
public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");

        EmailService emailService = new EmailService();
        UserRepository userRepository = new UserRepository();

        emailService.sendEmail(user, "Welcome to our platform!");
        userRepository.save(user);
    }
}
```

### Key Points
- **Single Responsibility**: Each class has one clearly defined responsibility.
- **Modularity**: Code is easier to modify without affecting other components.

---

## 2. Open/Closed Principle (OCP)

### Overview
The **Open/Closed Principle (OCP)** states that software entities (such as classes, modules, and functions) should be open for extension but closed for modification. This means that you should be able to extend the functionality of a class without altering its existing code.

### Implementation

For the OCP implementation, we created an interface `Shape` and two concrete classes: `Circle` and `Rectangle`. These classes implement the `Shape` interface and provide their own logic to calculate the area. The area calculation functionality in the `AreaCalculator` class is open for extension because we can add more shapes (e.g., `Triangle`, `Square`) without modifying existing code. 

This implementation prevents modifying the `AreaCalculator` class whenever new shapes are added.

### Code Example

```java
public class Main {

    // Shape interface
    interface Shape {
        double calculateArea();
    }

    // Circle class implementing the Shape interface
    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle class implementing the Shape interface
    static class Rectangle implements Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    // AreaCalculator class that calculates the area of any Shape
    static class AreaCalculator {
        public double calculateShapeArea(Shape shape) {
            return shape.calculateArea();
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();

        // Calculate areas of different shapes
        System.out.println("Area of Circle: " + calculator.calculateShapeArea(circle));
        System.out.println("Area of Rectangle: " + calculator.calculateShapeArea(rectangle));
    }
}
```

### Key Points
- **Open for Extension**: New shapes (like `Triangle` or `Square`) can be added by simply creating new classes that implement the `Shape` interface.
- **Closed for Modification**: The existing classes, such as `AreaCalculator`, are not modified when extending functionality.

---

## Conclusion

Both the **Single Responsibility Principle (SRP)** and the **Open/Closed Principle (OCP)** are crucial in making software systems flexible, maintainable, and scalable:
- **SRP** enforces separation of concerns, making each class responsible for a single part of the functionality.
- **OCP** promotes extensibility by ensuring that existing code doesn't need to change when new functionality is added.

By adhering to these principles, we achieve more modular, clean, and maintainable code in our Java project.

---

### References
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Java Documentation](https://docs.oracle.com/en/java/)

---
