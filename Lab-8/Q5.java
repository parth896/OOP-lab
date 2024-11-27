import java.util.Scanner;

class Mileage{
    int numberOfTrips;
    float miles[];
    float gallons[];
    {
        numberOfTrips=0;
    }
    Mileage(int n)
    {
        this.numberOfTrips=n;
        miles=new float[n];
        gallons=new float[n];
    }
    void getInput()
    {
        System.out.println("Enter the Number of Miles travelled for each trip:  ");
        Scanner input=new Scanner(System.in);
        for(int i=0;i<numberOfTrips;++i)
        {
            miles[i]=input.nextFloat();
        }
        System.out.println("Enter the Gallons of Fuel used for each trip:  ");
        for(int i=0;i<numberOfTrips;++i)
        {
            gallons[i]=input.nextFloat();
        }
        input.close();
    }
    void mileagePerTrip()
    {
        for(int i=0;i<numberOfTrips;++i)
        {
            float m=miles[i]/gallons[i];
            System.out.printf("%f" ,m);
        }System.out.printf("\n");
    }
    float totalMileage()
    {
        float totalMiles=0.0f,totalGallons=0.0f;
        for(int i=0;i<numberOfTrips;++i)
        {
            totalMiles+=miles[i];
            totalGallons+=gallons[i];
        }
        return totalMiles/totalGallons;
    }

}
public class Q5{
    public static void main(String[] args)
    {
        int n=10;
        Mileage M=new Mileage(n);
        M.getInput();
        M.mileagePerTrip();
        System.out.println(M.totalMileage());        
    }
}   