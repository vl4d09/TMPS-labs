# Student: Ungureanu Vlad
# Group: FAF-223

# SOLID Principles in Java: SRP and OCP Implementation

## 1. Single Responsibility Principle (SRP)

### Overview
The Single Responsibility Principle (SRP) states that a class should have only one reason to change. This principle encourages splitting responsibilities among different classes so that each class has a clear focus.

### Implementation

For SRP, I’ve separated user management, email sending, and database saving into distinct classes. The `User` class holds user data like name and email. The `EmailService` class handles the email-sending functionality. The `UserRepository` class deals with saving user information to the database. 

By splitting these concerns, we ensure that changing how emails are sent won’t affect user storage logic or the user data structure.

### Code Example

```java
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

public class EmailService {
    public void sendEmail(User user, String message) {
        System.out.println("Sending email to " + user.getEmail() + ": " + message);
    }
}

public class UserRepository {
    public void save(User user) {
        System.out.println("Saving " + user.getName() + " to the database.");
    }
}

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

### Key Takeaways
Each class here has a single responsibility, making the code easier to maintain and extend. If I need to modify how emails are sent, I only touch `EmailService`, and if I want to change how users are saved, I modify `UserRepository`. Everything else stays intact.

---

## 2. Open/Closed Principle (OCP)

### Overview
The Open/Closed Principle (OCP) means that a class should be open for extension but closed for modification. This allows adding new features or functionalities without modifying existing code.

### Implementation

For OCP, I’ve created an interface `Shape` that defines a method for calculating the area. The `Circle` and `Rectangle` classes implement this interface and provide their own logic to calculate the area. The `AreaCalculator` class remains unchanged no matter how many new shapes are added. New shapes like `Triangle` or `Square` can be added by simply implementing the `Shape` interface, without touching the `AreaCalculator` code.

### Code Example

```java
public class Main {

    interface Shape {
        double calculateArea();
    }

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

    static class AreaCalculator {
        public double calculateShapeArea(Shape shape) {
            return shape.calculateArea();
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator calculator = new AreaCalculator();

        System.out.println("Area of Circle: " + calculator.calculateShapeArea(circle));
        System.out.println("Area of Rectangle: " + calculator.calculateShapeArea(rectangle));
    }
}
```

### Key Takeaways
This design allows new shapes to be added without changing the existing `AreaCalculator` class. The system is easy to extend with new features, and the existing code is safe from unintended changes.

---

## Conclusion

Both SRP and OCP are important principles for making code modular, maintainable, and easy to extend. By adhering to SRP, we ensure that classes have distinct responsibilities, which reduces the chances of introducing bugs when making changes. With OCP, we can easily add new features without modifying the core functionality, making the system strong and flexible for future changes.

---

### References
- [SOLID Documentation](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)
- [SOLID Principles](https://en.wikipedia.org/wiki/SOLID)
- [Java Documentation](https://docs.oracle.com/en/java/)

---
