package figpackage;

abstract class Figure {
    public double r,a,v;
    public final double PI=3.1428;
    public abstract void dispArea();
    public abstract void dispVolume();
    public abstract void calcArea();
    public abstract void calcVolume();
}
