import java.util.Random;

public class Q7{
    public static void main(String[] args){
        Random rand=new Random();
        int iteration=1;
        System.out.printf("Iteration %d: ", iteration);
        int die1 = rand.nextInt(6) + 1;
        int die2 = rand.nextInt(6) + 1;
        int sum = die1 + die2;
        if (sum == 7 || sum == 11) {
            System.out.println(" You Won");
            return;
        }
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println(" Craps! You Lost");
            return;
        }
        System.out.printf("Die1: %d, Die2: %d ,Sum(points): %d\n",die1,die2,sum);
        iteration++;
        int points=sum;
        while(true)
        {
            System.out.printf("Iteration %d: ", iteration);
            die1=rand.nextInt(6) + 1;
            die2=rand.nextInt(6) + 1;
            sum=die1+die2;
            System.out.printf("Die1: %d, Die2: %d sum: %d",die1,die2,sum);
            if(sum==7)
            {
                System.out.println(" You Lost");
                break;
            }
            if(sum==points)
            {
                System.out.println(" You won ");
                break;
            }
            System.out.println("");
        }
    }
}