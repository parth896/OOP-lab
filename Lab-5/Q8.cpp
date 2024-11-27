#include <iostream>
#include <string>
using namespace std;
class c2;
class c1
{
private:
    int var;

public:
    friend void exchange(c1 *A, c2 *B);
    inline void display()
    {
        cout << "The Value of A: " << var << endl;
    }
    void getData()
    {
        cout << "Enter the Value of A: ";
        cin >> var;
    }
};

class c2
{
private:
    int var;

public:
    friend void exchange(c1 *A, c2 *B);
    inline void display()
    {
        cout << "The Value of B: " << var << endl;
    }
    void getData()
    {
        cout << "Enter the Value of B: ";
        cin >> var;
    }
};

void exchange(c1 *A, c2 *B)
{
    int temp = A->var;
    A->var = B->var;
    B->var = temp;
}

int main()
{
    c1 *A = new c1();
    c2 *B = new c2();
    A->getData();
    B->getData();
    exchange(A, B);
    A->display();
    B->display();
    return 0;
}