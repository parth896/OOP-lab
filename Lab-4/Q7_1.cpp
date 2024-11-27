#include <iostream>
#include <string>
#define endl "\n"
using namespace std;
class Employee
{
private:
    int emp_Id;
    string emp_Name;
    int emp_Age;

public:
    void display()
    {
        cout << "Employee ID: " << emp_Id << endl;
        cout << "Employee Name: " << emp_Name << endl;
        cout << "Employee Age: " << emp_Age << endl;
    }
    void getData()
    {
        cout << "Emp_ID: ";
        cin >> emp_Id;
        cout << "Emp_Name: ";
        cin >> emp_Name;
        cout << "Age: ";
        cin >> emp_Age;
    }
    friend void findEmployee(Employee a[], int n, int emp_Id);
};
void findEmployee(Employee a[], int n, int emp_Id)
{
    for (int i = 0; i < n; ++i)
    {
        if (a[i].emp_Id == emp_Id)
        {
            a[i].display();
            return;
        }
    }
    cout << "Not Found " << endl;
}
int main()
{
    int n;
    cout << "Enter the Number of employee" << endl;
    cin >> n;
    Employee a[n];
    for (int i = 0; i < n; ++i)
    {
        a[i].getData();
    }
    int emp_id;
    cout << "Enter the employee ID" << endl;
    cin >> emp_id;
    findEmployee(a, n, emp_id);

    return 0;
}