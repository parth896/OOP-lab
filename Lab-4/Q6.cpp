#include <iostream>
#include <string>
#define endl "\n"
using namespace std;
class B;
class A
{
private:
    int a;

public:
    A(int a)
    {
        this->a = a;
    }
    friend int addTwoNumbers(A a, B b);
};
class B
{
private:
    int b;

public:
    B(int b)
    {
        this->b = b;
    }
    friend int addTwoNumbers(A a, B b);
};
int addTwoNumbers(A a, B b)
{
    int result = a.a + b.b;
    return result;
}
int main()
{
    A a(10);
    B b(25);
    int addition = addTwoNumbers(a, b);
    cout << addition << endl;
    return 0;
}