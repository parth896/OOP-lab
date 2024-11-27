    import java.util.Scanner;
    class Savings{
        float totalMiles;
        float costPerGallon;
        float avgFee; //Assuming Avg fee as mileage
        float tollPerDay;
        public void getData()
        {
            Scanner input=new Scanner(System.in);
            System.out.println("Total Miles:  ");
            this.totalMiles=input.nextFloat();
            System.out.println("Cost Per Gallon:  ");
            this.costPerGallon=input.nextFloat();
            System.out.println("Average Fee Per Day:  ");
            this.avgFee=input.nextFloat();
            System.out.println("Tolls Per Day:  ");
            this.tollPerDay=input.nextFloat();
            input.close();
        }
        public double savings()
        {
            double ans=tollPerDay;
            double totalGallons=totalMiles/avgFee;
            double fuelCost=totalGallons*costPerGallon;
            ans+=fuelCost;
            return ans;
        }
    }
    public class DrivingCost {
        public static void main(String[] args) {
            Savings d=new Savings();
            d.getData();
            double savings=d.savings();
            System.out.println("Total Savings = "+savings);
        }
    }