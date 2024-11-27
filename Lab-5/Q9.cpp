#include <iostream>
#include <string>
using namespace std;
class C
{
    int a;

public:
    void getdata()
    {
        cout << "Enter the value  ";
        cin >> a;
    }
    void display()
    {
        cout << "A= " << a << endl;
    }
    ~C()
    {
        cout << "Destroyed !" << endl;
    }
};
int main()
{
    int n;
    cin >> n;
    C *arr = new C[n];
    for (int i = 0; i < n; ++i)
    {
        (arr + i)->getdata();
    }
    for (int i = 0; i < n; ++i)
    {
        (arr + i)->display();
    }
    delete[] arr;
}
