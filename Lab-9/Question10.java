import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        System.out.print("Enter the threshold number n: ");
        int n = scanner.nextInt();
        
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char ch : input.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        
        System.out.println("Characters exceeding the count of " + n + ":");
        
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > n) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
