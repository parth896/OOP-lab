package figpackage;

public class Demo {
    public static void main(String[] args) {
        Sphere s=new Sphere(10);
        Cone c=new Cone(10,12,34);
        Cylinder cy=new Cylinder(10, 10);
        s.calcArea();
        c.calcArea();
        cy.calcArea();
        s.calcVolume();
        c.calcVolume();
        cy.calcVolume();
        s.dispArea();
        c.dispArea();
        cy.dispArea();
        s.dispVolume();
        c.dispVolume();
        cy.dispVolume();
    }
}
