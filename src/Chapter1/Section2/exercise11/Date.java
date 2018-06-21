package Chapter1.Section2.exercise11;

import edu.princeton.cs.introcs.StdOut;

public class Date {

    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y)
    {  month = m; day = d; year = y; }

    public int month()
    {  return month;  }

    public int day()
    {  return day;  }

    public int year()
    {  return year;  }

    public String toString()
    {  return month() + "/" + day() + "/" + year();  }

    public void SmartDate () throws InvalidDateException {

        if (year < 1800 || year > 2100)
            throw new InvalidDateException(year);
        if (month < 1 || month > 12)
            throw new InvalidDateException(month);
        if (day < 1 || day > 31)
            throw new InvalidDateException(day);

    }

    public boolean equals(Object x)
    {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;

        Date that = (Date) x;
        if (this.day != that.day)
            return false;
        if (this.month != that.month)
            return false;
        if (this.year != that.year)
            return false;
        return true;
    }

    public static void main (String arg[]) {

        int day = 2;
        int month = 10;
        int year = 2000;

        Date date = new Date(day, month, year);

        try {

            date.SmartDate();

        } catch (InvalidDateException e) {

            System.out.println("Invalid date: " + e.getDate());
            e.printStackTrace();

        }

        StdOut.println("Successful! The date is: " + day + "/" + month + "/" + year);

    }

}
