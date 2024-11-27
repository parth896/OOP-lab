#include <iostream>
using namespace std;

class Integer
{
private:
    int a;

public:
    Integer(int a = 0)
    {
        this->a = a;
    }
    friend istream &operator>>(istream &mycin, Integer &i)
    {
        mycin >> i.a;
        return mycin;
    }
    friend ostream &operator<<(ostream &mycout, Integer &i)
    {
        mycout << i.a;
        return mycout;
    }
};

int main()
{
    Integer a;
    cin >> a;
    cout << a << endl;
    return 0;
}