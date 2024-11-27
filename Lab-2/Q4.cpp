#include <iostream>
using namespace std;
class Patient
{
    string sex;
    string date;
    string Nature;
    int wardNo;
    int bedNo;
    int Age;

public:
    Patient()
    {
        cout << "Default Constructor" << endl;
    }
    Patient(string sex, string date, string Nature, int wardNo, int Age, int bedNo)
    {
        this->sex = sex;
        this->date = date;
        this->Nature = Nature;
        this->wardNo = wardNo;
        this->Age = Age;
        this->bedNo = bedNo;
    }
    Patient(Patient &e)
    {
        sex = e.sex;
        date = e.date;
        Nature = e.Nature;
        wardNo = e.wardNo;
        Age = e.Age;
        bedNo = e.bedNo;
    }
    ~Patient()
    {
        cout << "Destructor is called" << endl;
    }

    void Display();
    friend void getNature(Patient e);
};
inline void Patient::Display()
{
    cout << "Sex " << sex << endl;
    cout << "date " << date << endl;
    cout << "Nature " << Nature << endl;
    cout << "BedNo " << bedNo << endl;
    cout << "Age" << Age << endl;
    cout << "WardNo" << wardNo << endl;
}
void getNature(Patient e)
{
    cout << "Patient Nature of illness is " << e.Nature << endl;
}
int main()
{
    Patient e1;
    Patient e2("Male", "12-02-2024", "Fever", 23, 19, 397);
    Patient e3(e2);
    Patient *e4 = new Patient("Female", "13-02-2024", "Vomiting", 21, 22, 524);
    e3.Display();
    e4->Display();
    getNature(e2);
    delete (e4);
    return 0;
}