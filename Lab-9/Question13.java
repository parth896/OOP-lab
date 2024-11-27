interface Function {
    int evaluate(int value);
}

class Half implements Function {
    public int evaluate(int value) {
        return value / 2;
    }
}

public class Question13{

    public static int[] processArray(int[] values) {
        int[] result = new int[values.length];
        Half half = new Half();

        for (int i = 0; i < values.length; i++) {
            result[i] = half.evaluate(values[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] inputArray = {14, 24, 34, 46, 58};
        int[] outputArray = processArray(inputArray);

        System.out.print("Input Array: ");
        for (int value : inputArray) {
            System.out.print(value + " ");
        }

        System.out.print("\nOutput Array: ");
        for (int value : outputArray) {
            System.out.print(value + " ");
        }
    }
}
