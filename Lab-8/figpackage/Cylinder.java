package figpackage;

public class Cylinder extends Figure{
    public double h;
    public Cylinder(double Radius,double Height)
    {
        this.r=Radius;
        this.h=Height;
    }
    @Override
    public void calcArea()
    {
        a=2*PI*r*(r+h);
    }
    @Override
    public void calcVolume()
    {
        v=PI*r*r*h;
    }
    @Override
    public void dispArea()
    {
        System.out.printf("The Area of Cylinder is %2f\n",a);
    }
    @Override
    public void dispVolume()
    {
        System.out.printf("The Volume of Cylinder is %2f\n",v);
    }
}
