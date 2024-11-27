#include <iostream>
using namespace std;
class c
{
    char *arr;
    int size;

public:
    c()
    {
        cout << "Default Constructor" << endl;
    }
    c(int size)
    {
        this->size = size;
        arr = new char[size];
    }
    c(c &c1)
    {
        size = c1.size;
        arr = new char[size];
        for (int i = 0; i < size; ++i)
        {
            arr[i] = c1.arr[i];
        }
    }
    void getData()
    {
        cout << "Enter the elements of the array" << endl;
        for (int i = 0; i < size; ++i)
        {
            cin >> arr[i];
        }
    }
    void findInArray()
    {
        string s, a;
        cout << "Enter s1 & s2" << endl;
        cin >> s >> a;
        if (s.length() != a.length())
        {
            cout << "Invalid" << endl;
            return;
        }
        int strsize = s.length();
        if (size < strsize)
        {
            for (int i = 0; i < size; ++i)
            {
                cout << arr[i];
            }
            cout << endl;
            return;
        }

        for (int i = 0; i < size - strsize + 1; ++i)
        {
            string str = "";
            for (int j = i; j < strsize + i; ++j)
            {
                str += arr[j];
            }
            if (str == s)
            {
                int k = 0;
                for (int j = i; j < strsize + i; ++j)
                {
                    arr[j] = a[k++];
                }
            }
        }
        for (int i = 0; i < size; ++i)
        {
            cout << arr[i];
        }
        cout << endl;
    }
};
int main()
{
    c c1;
    c c2(int(10));
    c2.getData();
    c2.findInArray();
    return 0;
}