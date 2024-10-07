public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");

        // Creating the services
        EmailService emailService = new EmailService();
        UserRepository userRepository = new UserRepository();

        emailService.sendEmail(user, "Welcome to our platform!");
        userRepository.save(user);
    }
}