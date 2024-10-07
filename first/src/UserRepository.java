public class UserRepository {
    public void save(User user) {
        System.out.println("Saving " + user.getName() + " to the database.");
    }
}

