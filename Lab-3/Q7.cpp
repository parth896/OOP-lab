#include <iostream>
using namespace std;
class Book
{
private:
    int AccessionNumber;
    string AuthorName;
    string Title;
    int YearOfPublication;
    string PublishersName;
    float Cost;

public:
    Book()
    {
        cout << "Default Constructor" << endl;
    }
    Book(int AccessionNumber, string AuthorName, string Title, int YearOfPublication, string PublishersName, float Cost)
    {
        this->AccessionNumber = AccessionNumber;
        this->AuthorName = AuthorName;
        this->Title = Title;
        this->YearOfPublication = YearOfPublication;
        this->PublishersName = PublishersName;
        this->Cost = Cost;
    }
    Book(Book &b)
    {
        this->AccessionNumber = b.AccessionNumber;
        this->AuthorName = b.AuthorName;
        this->Title = b.Title;
        this->YearOfPublication = b.YearOfPublication;
        this->PublishersName = b.PublishersName;
        this->Cost = b.Cost;
    }
    ~Book()
    {
        cout << "Default Destructor" << endl;
    }
    void getBookDetails()
    {
        cout << "AccessionNumber: " << AccessionNumber << endl;
        cout << "Title: " << Title << endl;
        cout << "Cost: " << Cost << endl;
    }
    void getAuthorDetails()
    {
        cout << "Author: " << AuthorName << endl;
    }
    void getPublicationDetails();
    friend class Details;
};
inline void Book::getPublicationDetails()
{
    cout << "PublicationName: " << PublishersName << endl;
    cout << "Year of Publication: " << YearOfPublication << endl;
    cout << endl;
}
class Details
{
public:
    void BookDetails(Book &b)
    {
        cout << "AccessionNumber: " << b.AccessionNumber << endl;
        cout << "Title: " << b.Title << endl;
        cout << "Cost: " << b.Cost << endl;
        cout << "Author: " << b.AuthorName << endl;
        cout << "PublicationName: " << b.PublishersName << endl;
        cout << "Year of Publication: " << b.YearOfPublication << endl;
        cout << endl;
    }
};

int main()
{
    Book HP1(1, "J.K Rowling", "Harry Potter And the Philosphers Stone", 2001, "WarnerBros", 12000);
    HP1.getBookDetails();
    HP1.getAuthorDetails();
    HP1.getPublicationDetails();
    Book *HP2 = new Book(2, "J.K Rowling", "Harry Potter And the Chambers of Secret", 2003, "WarnerBros", 13000);
    Details display;
    display.BookDetails(*HP2);
    delete (HP2);
    return 0;
}