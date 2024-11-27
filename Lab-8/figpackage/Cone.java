package figpackage;

public class Cone extends Figure{
    public double s,h;
    public Cone(double r,double s,double h)
    {
        this.r=r;
        this.s=s;
        this.h=h;
    }
    @Override
    public void calcArea()
    {
        a=(r*PI)*(r+s);
    }
    @Override
    public void calcVolume()
    {
        v=(PI*r*s*h)/3;
    }
    @Override
    public void dispArea()
    {
        System.out.printf("Area of the cone is %2f\n",a);
    }
    @Override
    public void dispVolume()
    {   
        System.out.printf("Volume of the cone is %2f\n",v);
    }
}
