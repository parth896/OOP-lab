import java.util.HashSet;
import java.util.Scanner;

public class Question11 {

    public static boolean isPerfectString(String input) {
        HashSet<Character> charSet = new HashSet<>();
        
        for (char ch : input.toCharArray()) {
            if (charSet.contains(ch)) {
                return false;
            }
            charSet.add(ch);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        if (isPerfectString(input)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }
    }
}
