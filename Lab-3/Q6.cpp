#include <iostream>
using namespace std;
class MarkSheet
{
private:
    string Name;
    int RollNumber;
    string SubjectCode;
    string SubjectName;
    float InternalMarks;
    float ExternalMarks;

public:
    MarkSheet()
    {
        cout << "Default Constructor" << endl;
    }
    MarkSheet(string Name, int RollNumber, string SubjectCode, string SubjectName, float InternalMarks, float ExternalMarks)
    {
        this->Name = Name;
        this->RollNumber = RollNumber;
        this->SubjectCode = SubjectCode;
        this->SubjectName = SubjectName;
        this->InternalMarks = InternalMarks;
        this->ExternalMarks = ExternalMarks;
    }
    MarkSheet(MarkSheet &M)
    {
        this->Name = M.Name;
        this->RollNumber = M.RollNumber;
        this->SubjectCode = M.SubjectCode;
        this->SubjectName = M.SubjectName;
        this->InternalMarks = M.InternalMarks;
        this->ExternalMarks = M.ExternalMarks;
    }
    ~MarkSheet()
    {
        cout << "Default Destructor" << endl;
    }
    void getStudentDetails()
    {
        cout << "RollNumber: " << RollNumber << endl;
        cout << "Name: " << Name << endl;
    }
    void getSubjectDetails()
    {
        cout << "SubjectCode: " << SubjectCode << endl;
        cout << "SubjectName: " << SubjectName << endl;
    }
    void getMarks();
    friend class Display;
};
inline void MarkSheet::getMarks()
{
    cout << "InternalMarks = " << InternalMarks << endl;
    cout << "ExternalMarks = " << ExternalMarks << endl;
    cout << "Total Marks = " << InternalMarks + ExternalMarks << endl;
    cout << endl;
}
class Display
{
public:
    void Marksheet(MarkSheet &m)
    {
        m.getStudentDetails();
        m.getSubjectDetails();
        m.getMarks();
    }
};
int main()
{
    MarkSheet deepak("Deepak", 80, "DSA", "DataStructures And Algorithms", 29, 97);
    Display details;
    details.Marksheet(deepak);
    MarkSheet *divyansh = new MarkSheet("Divyansh", 82, "DSA", "DataStructures And Algorithms", 30, 100);
    details.Marksheet(*divyansh);
    delete (divyansh);
    return 0;
}