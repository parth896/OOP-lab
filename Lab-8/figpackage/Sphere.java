package figpackage;

public class Sphere extends Figure{
    public Sphere(double Radius)
    {
        this.r=Radius;
    }
    @Override
    public void calcArea()
    {
        a=4*PI*r*r;
    }
    @Override
    public void calcVolume()
    {
        v=(4*PI*r*r*r)/3;
    }
    @Override
    public void dispArea()
    {
        System.out.printf("The Area of the Sphere is %2f\n",a);
    }
    @Override
    public void dispVolume()
    {
        System.out.printf("The Volume of the Sphere is %2f\n",v);
    }
}
