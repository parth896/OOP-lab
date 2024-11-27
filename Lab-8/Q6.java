import java.util.Scanner;

class Tata{
    public static void Model(String s)
    {
        switch (s) {
            case "SUV": 
                System.out.println("TATA SAFARI"); 
                break;
            case "SEDAN":
                System.out.println("TATA INDIGO");
                break;
            case "ECONOMY":
                System.out.println("TATA INDICA");
                break;
            default:
                System.out.println("TATA NANO");
                break;
        }
    }
}
public class Q6 {   
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Model");
        String s=input.nextLine();
        Tata.Model(s.toUpperCase());
        input.close();
    }
}
