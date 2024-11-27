#include <iostream>
using namespace std;

class Vector
{
private:
    int n;
    int *arr;

public:
    Vector(int n)
    {
        this->n = n;
        arr = new int[n];
    }

    int size()
    {
        return n;
    }

    friend istream &operator>>(istream &mycin, Vector &v)
    {
        for (int i = 0; i < v.n; ++i)
        {
            mycin >> v.arr[i];
        }
        return mycin;
    }

    friend ostream &operator<<(ostream &mycout, Vector &v)
    {
        for (int i = 0; i < v.n; ++i)
        {
            mycout << v.arr[i] << " ";
        }
        mycout << endl;
        return mycout;
    }
    Vector operator-(Vector v)
    {

        Vector ans(n);
        for (int i = 0; i < n; ++i)
        {
            ans.arr[i] = this->arr[i] - v.arr[i];
        }
        return ans;
    }
    Vector operator+(Vector v)
    {

        Vector ans(n);
        for (int i = 0; i < n; ++i)
        {
            ans.arr[i] = this->arr[i] + v.arr[i];
        }
        return ans;
    }
};

int main()
{
    Vector v(5);
    cin >> v;
    Vector u(5);
    cin >> u;
    Vector diff = v - u;
    cout << diff;
    Vector sum = v + u;
    cout << sum;
    return 0;
}
