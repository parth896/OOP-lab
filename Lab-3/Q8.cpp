#include <iostream>
using namespace std;
class PersonDetails
{
private:
    string Name;
    string DateOfBirth;
    string BloodGroup;
    float Height;
    float Weight;
    int InsuranceNumber;
    string ContactAddress;
    long TelephoneNumber;
    int DrivingLicense;

public:
    PersonDetails()
    {
        cout << "Default Constructor" << endl;
    }
    PersonDetails(string Name, string DateOfBirth, string BloodGroup, float Height, float Weight, int InsuranceNumber, string ContactAddress, long TelephoneNumber, int DrivingLicense)
    {
        this->Name = Name;
        this->DateOfBirth = DateOfBirth;
        this->BloodGroup = BloodGroup;
        this->Height = Height;
        this->Weight = Weight;
        this->InsuranceNumber = InsuranceNumber;
        this->ContactAddress = ContactAddress;
        this->TelephoneNumber = TelephoneNumber;
        this->DrivingLicense = DrivingLicense;
    }
    PersonDetails(PersonDetails &P)
    {
        this->Name = P.Name;
        this->DateOfBirth = P.DateOfBirth;
        this->BloodGroup = P.BloodGroup;
        this->Height = P.Height;
        this->Weight = P.Weight;
        this->InsuranceNumber = P.InsuranceNumber;
        this->ContactAddress = P.ContactAddress;
        this->TelephoneNumber = P.TelephoneNumber;
        this->DrivingLicense = P.DrivingLicense;
    }
    ~PersonDetails()
    {
        cout << "Default Destructor" << endl;
    }
    void getPatientDetails()
    {
        cout << "Name: " << Name << endl;
        cout << "Date of Birth: " << DateOfBirth << endl;
        cout << "Blood Group: " << BloodGroup << endl;
        cout << "Height: " << Height << endl;
        cout << "Weight: " << Weight << endl;
        cout << "Insurance Policy Number: " << InsuranceNumber << endl;
    }
    void getContactInfo();
    friend class Details;
};
inline void PersonDetails::getContactInfo()
{
    cout << "Contact Address: " << ContactAddress << endl;
    cout << "Telephone Number: " << TelephoneNumber << endl;
    cout << "Driving License Number: " << DrivingLicense << endl;
    cout << endl;
}
class Details
{
public:
    void display(PersonDetails &p)
    {
        cout << "Name: " << p.Name << endl;
        cout << "Date of Birth: " << p.DateOfBirth << endl;
        cout << "Blood Group: " << p.BloodGroup << endl;
        cout << "Height: " << p.Height << endl;
        cout << "Weight: " << p.Weight << endl;
        cout << "Insurance Policy Number: " << p.InsuranceNumber << endl;
        cout << "Contact Address: " << p.ContactAddress << endl;
        cout << "Telephone Number: " << p.TelephoneNumber << endl;
        cout << "Driving License Number: " << p.DrivingLicense << endl;
        cout << endl;
    }
};
int main()
{
    PersonDetails P1("Deepak", "18-09-2005", "AB+", 5.9, 90, 3234349, "333 EWS Hostel SVNIT", 7674808737, 92848023);
    P1.getPatientDetails();
    P1.getContactInfo();
    PersonDetails *P2 = new PersonDetails("Divyansh", "06-06-2005", "A+", 5.9, 50, 34242345, "334 EWS Hostel SVNIT", 708028394, 389004923);
    Details display;
    display.display(*P2);
    delete (P2);
    return 0;
}