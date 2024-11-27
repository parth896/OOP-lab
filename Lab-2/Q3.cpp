#include <iostream>
using namespace std;
class Employee
{
    string Name;
    string code;
    string Designation;
    int Experience;
    int Age;

public:
    Employee()
    {
        cout << "Default Constructor" << endl;
    }
    Employee(string Name, string code, string Designation, int Experience, int Age)
    {
        this->Name = Name;
        this->code = code;
        this->Designation = Designation;
        this->Experience = Experience;
        this->Age = Age;
    }
    Employee(Employee &e)
    {
        Name = e.Name;
        code = e.code;
        Designation = e.Designation;
        Experience = e.Experience;
        Age = e.Age;
    }
    ~Employee()
    {
        cout << "Destructor is called" << endl;
    }

    void Display();
    friend void getEmpCode(Employee e);
};
inline void Employee::Display()
{
    cout << "Name " << Name << endl;
    cout << "code " << code << endl;
    cout << "Designation " << Designation << endl;
    cout << "Experience " << Experience << endl;
    cout << "Age" << Age << endl;
}
void getEmpCode(Employee e)
{
    cout << "Employee Code is " << e.code << endl;
}
int main()
{
    Employee e1;
    Employee e2("Deepak", "2121", "Manager", 20, 34);
    Employee e3(e2);
    Employee *e4 = new Employee("Divyansh", "23232", "Apprentice", 1, 23);
    e3.Display();
    e4->Display();
    getEmpCode(e2);
    delete (e4);
    return 0;
}