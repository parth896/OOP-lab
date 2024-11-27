import java.util.Scanner;

public class Question12 {

    public static int countPatternOccurrences(int a, int b, String pattern) {
        int count = 0;

        for (int i = a; i <= b; i++) {
            if (String.valueOf(i).contains(pattern)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter range (a b): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print("Enter pattern: ");
        String pattern = scanner.next();

        int occurrences = countPatternOccurrences(a, b, pattern);
        System.out.println("The number of times " + pattern + " occurred between " + a + " and " + b + ": " + occurrences);
    }
}
