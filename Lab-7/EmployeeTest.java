class Employee{
    private String name,lastName;
    private double salary;
    Employee(){};
    Employee(String name,String lastName,double salary)
    {
        this.name=name;
        this.lastName=lastName;
        this.salary=salary;
    }   
    Employee(String name,String lastName)
    {
        this.name=name;
        this.lastName=lastName;
    }
    String getName()
    {
        return name;
    }
    String getLastName()
    {
        return lastName;
    }
    double getSalary()
    {   
        return salary;
    }
    void setName(String name)
    {   
        this.name=name;
    }
    void setLastName(String lastName)
    {
        this.lastName=lastName;
    }
    void setSalary(double salary)
    {   
        this.salary=salary;
    }
    void hikeSalary(double hike){
        salary=salary+salary*(hike/100);
    }
}

public class EmployeeTest{
    public static void main(String[] args)
    {
        Employee e1=new Employee("Deepak","Challa",3900000);
        Employee e2=new Employee("Divyansh","Kumar");
        e2.setSalary(3500000);
        e1.hikeSalary(10);
        e2.hikeSalary(10);
        System.out.printf("The Salary of %s is %.2f\n",e1.getName(),e1.getSalary());
        System.out.printf("The Salary of %s is %.2f\n",e2.getName(),e2.getSalary());
    }
}