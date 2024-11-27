/*

    The Problem Statement of the Question 7 is same as the Question 5
    So same code is applicable

*/

#include <iostream>
using namespace std;
// Declaration of the struct
typedef struct Arithmetic
{
    int no1;
    int no2;
} Arithmetic;

void add(Arithmetic a) // Add two numbers in the struct
{
    cout << "The sum of the two numbers is " << a.no1 + a.no2 << endl;
}
void sub(Arithmetic a) // Substracts two numbers in the struct
{
    cout << "The Difference of the two numbers is " << a.no1 - a.no2 << endl;
}
void mul(Arithmetic a) // Multiplies two numbers in the struct
{
    cout << "The Product of the two numbers is " << a.no1 * a.no2 << endl;
}
void div(Arithmetic a) // Dividies two numbers in the struct
{
    cout << "The Quotient of the two numbers is " << float(a.no1 / a.no2) << endl;
}
int main()
{
    Arithmetic a;                         // Initialisation of a struct instance
    cout << "Enter two numbers " << endl; // Prompt to the user
    cin >> a.no1 >> a.no2;                // Input of the two numbers in the struct
    char c;
    cout << "Enter the Operation to be performed" << endl;
    cin >> c;
    switch (c)
    {
    case '+':
        add(a);
        break;
    case '-':
        sub(a);
        break;

    case '*':
        mul(a);
        break;

    case '/':
        div(a);
        break;

    default:
        cout << "Invalid Operation" << endl;
    }
    return 0;
}