package lesson15hw14;

public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final String ALLOWED_LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALLOWED_SPECIAL_CHARACTERS = "!@#$%^&*()-_+=;:,./?\\|`~[]{}";
    private static final String ALLOWED_NUMBERS = "0123456789";

    public static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < MIN_LENGTH) {
            throw new WeakPasswordException("Password is to short. Minimum length: " + MIN_LENGTH + " symbols.");
        }

        boolean hasLetter = false;
        boolean hasSpecialCharacter = false;
        boolean hasNumber = false;
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        for (char ch : password.toCharArray()) {
            if (ALLOWED_LETTERS.indexOf(ch) != -1) {
                hasLetter = true;
                if (Character.isLowerCase(ch)) {
                    hasLowercase = true;
                } else if (Character.isUpperCase(ch)) {
                    hasUppercase = true;
                }
            } else if (ALLOWED_SPECIAL_CHARACTERS.indexOf(ch) != -1) {
                hasSpecialCharacter = true;
            } else if (ALLOWED_NUMBERS.indexOf(ch) != -1) {
                hasNumber = true;
            }
        }

        if (!hasLetter) {
            throw new WeakPasswordException("Password must contain at least one letter.");
        }

        if (!hasSpecialCharacter) {
            throw new WeakPasswordException("Password must contain at least one special character.");
        }

        if (!hasNumber) {
            throw new WeakPasswordException("Password must contain at least one number.");
        }

        if (!hasLowercase || !hasUppercase) {
            throw new WeakPasswordException("Password must contain at least one uppercase and one lowercase letter.");
        }

        System.out.println("Password is successfully validated.");
    }
}
