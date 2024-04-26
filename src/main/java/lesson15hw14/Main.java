package lesson15hw14;

public class Main {
    public static void main(String[] args) {
        try {
            PasswordValidator.validatePassword("Password@123");
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
