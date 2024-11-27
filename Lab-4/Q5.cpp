#include <iostream>
#include <string>
using namespace std;
#define endl "\n"

class Publication
{
public:
    string title;
    float price;
    string author;
};
class Book : public Publication
{
public:
    int pcount;

    void getData()
    {
        cout << "Enter the Following Fields" << endl;
        cout << "Title: ";
        cin >> title;
        cout << "Author: ";
        cin >> author;
        cout << "Price: ";
        cin >> price;
        cout << "Page Count: ";
        cin >> pcount;
    }
    void display()
    {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "Price: " << price << endl;
        cout << "Page Count: " << pcount << endl;
    }
};
class Ebook : public Publication
{
public:
    int ptime;
    void getData()
    {
        cout << "Enter the Following Fields" << endl;
        cout << "Title: ";
        cin >> title;
        cout << "Author: ";
        cin >> author;
        cout << "Price: ";
        cin >> price;
        cout << "Play Time: ";
        cin >> ptime;
    }
    void display()
    {
        cout << "Title: " << title << endl;
        cout << "Author: " << author << endl;
        cout << "Price: " << price << endl;
        cout << "Play Time: " << ptime << endl;
    }
};
int main()
{
    Book a;
    Ebook b;
    a.getData();
    b.getData();
    a.display();
    b.display();
    return 0;
}