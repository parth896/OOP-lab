class Date{
    private int day,month,year;
    Date(int day,int month,int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    void setMonth(int month)
    {
        this.month=month;
    }
    void setYear(int year)
    {
        this.year=year;
    }
    void setDay(int day)
    {
        this.day=day;
    }
    int getMonth()
    {
        return month;
    }
    int getYear()
    {
        return year;
    }
    int getDay()
    {
        return day;
    }
    void printDate()
    {
        System.out.printf("%d/%d/%d\n",month,day,year);
    }
}

public class DateTest {
    public static void main(String [] args)
    {
        Date D=new Date(18,9,2005);
        D.printDate();
        D.setYear(2024);
        D.printDate();
    }
}
