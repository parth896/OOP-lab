import java.util.Scanner;

public class Question9{

    public static boolean isValidPassword(String password) {
        if (password.length() < 5 || password.length() > 12) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch) || !Character.isLetterOrDigit(ch)) {
                return false;
            }

            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            if (i >= 2 && password.charAt(i) == password.charAt(i - 1) && password.charAt(i - 1) == password.charAt(i - 2)) {
                return false;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        return hasLowerCase && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
