#include <iostream>
#define endl "\n"
using namespace std;

class RealNumber
{
public:
    float real;
    RealNumber()
    {
        real = 0;
    }
    RealNumber(float real)
    {
        this->real = real;
    }
    static float multiply(float r1, float r2)
    {
        return r1 * r2;
    }
};
class ImaginaryNumber
{
public:
    float img;
    ImaginaryNumber()
    {
        img = 0;
    }
    ImaginaryNumber(float img)
    {
        this->img = img;
    }
    static float multiply(float I1, float I2)
    {
        float result = I1 * I2;
        return -result;
    }
};
class ComplexNumber : public RealNumber, public ImaginaryNumber
{
public:
    static ComplexNumber multiply(ComplexNumber C1, ComplexNumber C2)
    {
        ComplexNumber ans;
        ans.real = RealNumber::multiply(C1.real, C2.real) + ImaginaryNumber::multiply(C1.img, C2.img);
        ans.img = RealNumber::multiply(C1.real, C2.img) + RealNumber::multiply(C1.img, C2.real);
        return ans;
    }
    void display()
    {
        if (img < 0)
        {
            cout << real << "-" << -img << "i" << endl;
            return;
        }
        else
        {
            cout << real << "+" << img << "i" << endl;
        }
    }
    void getData()
    {
        cout << "Real Part: ";
        cin >> real;
        cout << "Imaginary Part: ";
        cin >> img;
    }
};

int main()
{
    ComplexNumber C1, C2;
    C1.getData();
    C2.getData();
    ComplexNumber C3 = ComplexNumber::multiply(C1, C2);
    C3.display();
    return 0;
}