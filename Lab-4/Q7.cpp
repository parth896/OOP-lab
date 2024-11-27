#include <iostream>
#define endl "\n"

using namespace std;
class Cuboid
{
private:
    float a, b, c;

public:
    Cuboid(float a, float b, float c)
    {
        this->a = a;
        this->b = b;
        this->c = c;
    }
    void volume()
    {
        float vol = a * b * c;
        cout << "Volume = " << vol << endl;
    }
    void display()
    {
        cout << "Dimensions are " << a << "x" << b << "x" << c << endl;
    }
    friend class Cube;
};
class Cube
{
public:
    static void makeCube(Cuboid &A)
    {
        A.b = A.a;
        A.c = A.a;
    }
};
int main()
{
    Cuboid A(12, 45.5, 22);
    A.display();
    A.volume();
    Cube::makeCube(A);
    A.display();
    A.volume();
    return 0;
}