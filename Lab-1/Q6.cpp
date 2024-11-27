#include <iostream>
using namespace std;
typedef struct Complex // Declaration of the struct
{
    float real;
    float img;
} complex;
// A function to print Complex number as in the traditional mathematic notation
void printComplex(float a, float b)
{
    if (b < 0)
    {
        cout << a << "-" << -b << "i" << endl;
    }
    else
    {
        cout << a << "+" << b << "i" << endl;
    }
}

// Add's Two complex numbers and returns a complex number
complex add(complex a, complex b)
{
    int real = a.real + b.real;
    int img = a.img + b.img;
    complex ans;
    ans.real = real;
    ans.img = img;
    return ans;
}
// Subtracts's Two complex numbers and returns a complex number

complex sub(complex a, complex b)
{
    int real = a.real - b.real;
    int img = a.img - b.img;
    complex ans;
    ans.real = real;
    ans.img = img;
    return ans;
}
// Multiplies's Two complex numbers and returns a complex number

complex mul(complex a, complex b)
{
    float real = (a.real * b.real) + (a.img * b.img);
    float img = (a.real * b.img) + (a.img * b.real);
    complex ans;
    ans.real = real;
    ans.img = img;
    return ans;
}
// Divides's Two complex numbers and returns a complex number

complex div(complex a, complex b)
{
    float denominator = (b.real * b.real) + (b.img * b.img);
    float real = ((a.real * b.real) - (a.img * b.img)) / denominator;
    float img = ((a.img * b.real) - (a.real * b.img)) / denominator;
    complex ans;
    ans.real = real;
    ans.img = img;
    return ans;
}

// A Function which allows Users to choose from different arithmetic operations
void menu(complex a, complex b)
{
    char c;
    cout << "Choose the operation to perform " << endl;
    cin >> c;
    complex ans;
    switch (c)
    {
    case '+':
        ans = add(a, b);
        printComplex(ans.real, ans.img);

        break;
    case '-':
        ans = sub(a, b);
        printComplex(ans.real, ans.img);

        break;
    case '*':
        ans = mul(a, b);
        printComplex(ans.real, ans.img);

        break;
    case 'x':
        ans = mul(a, b);
        printComplex(ans.real, ans.img);

        break;
    case '/':
        ans = div(a, b);
        printComplex(ans.real, ans.img);

        break;
    default:
        cout << "Invalid Operation" << endl;
    }
}
int main()
{
    complex a, b; // Initialisation of A,B
    cout << "Enter the first complex number" << endl;
    cin >> a.real >> a.img;
    cout << "Enter the second Complex number" << endl;
    cin >> b.real >> b.img;
    menu(a, b); // Function call to choose arithmetic operations
    return 0;
}