#include <iostream>
using namespace std;
class Payroll
{
private:
    string EmployeeName;
    string EmployeeCode;
    string Designation;
    int AccountNumber;
    string DateOfJoining;
    float BasicPay;
    float DA, HRA, CCA;
    float PPF, GPF, CPF, LIC, NSS, NSC;

public:
    Payroll()
    {
        cout << "Default Constructor" << endl;
        DA = 0, HRA = 0, CCA = 0;
    }
    Payroll(string Name, string Code, string Desig, int ANo, string Date, float BP)
    {
        this->EmployeeName = Name;
        this->EmployeeCode = Code;
        this->Designation = Desig;
        this->AccountNumber = ANo;
        this->DateOfJoining = Date;
        this->BasicPay = BP;
    }
    Payroll(Payroll &p)
    {
        this->EmployeeName = p.EmployeeName;
        this->EmployeeCode = p.EmployeeCode;
        this->Designation = p.Designation;
        this->AccountNumber = p.AccountNumber;
        this->DateOfJoining = p.DateOfJoining;
        this->BasicPay = p.BasicPay;
    }
    void getBonus()
    {
        cout << "Bonus of " << EmployeeName << endl;
        cout << "DA: ";
        cin >> DA;
        cout << "\nHRA: ";
        cin >> HRA;
        cout << "\nCCA: ";
        cin >> CCA;
        cout << "\n";
    }
    void getDeductions()
    {
        cout << "Deductions of " << EmployeeName << endl;
        cout << "PPF: ";
        cin >> PPF;
        cout << "\nGPF: ";
        cin >> GPF;
        cout << "\nCPF: ";
        cin >> CPF;
        cout << "\nLIC: ";
        cin >> LIC;
        cout << "\nNSS: ";
        cin >> NSS;
        cout << "\nNSC: ";
        cin >> NSC;
        cout << "\n";
    }
    ~Payroll()
    {
        cout << "Default Destructor" << endl;
    }
    friend class Display;
    void getSalary();
};
inline void Payroll::getSalary()
{
    float grossPay = BasicPay + DA + HRA + CCA;
    float Deductions = PPF + GPF + LIC + NSS + NSC + CPF;
    float salary = grossPay - Deductions;
    cout << "Net Salary = " << salary << endl;
}
class Display
{
public:
    void showDetails(Payroll &p)
    {
        cout << "Employee Name: " << p.EmployeeName << endl;
        cout << "Employee Code: " << p.EmployeeCode << endl;
        cout << "Designation: " << p.Designation << endl;
        cout << "Account Number: " << p.AccountNumber << endl;
        cout << "Date of Joining: " << p.DateOfJoining << endl;
        cout << "Basic Pay: " << p.BasicPay << endl;
    }
};
int main()
{
    Payroll A("Deepak", "123", "Manager", 92392049, "25-05-2023", 100000);
    A.getBonus();
    A.getDeductions();
    Display details;
    details.showDetails(A);
    A.getSalary();
    Payroll *B = new Payroll("Divyansh", "242", "HR", 8078073, "21-09-2017", 300000);
    B->getBonus();
    B->getDeductions();
    details.showDetails(*B);
    B->getSalary();
    delete (B);
    return 0;
}