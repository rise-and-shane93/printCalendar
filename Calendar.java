import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {

        // Scanner input = new Scanner(System.in);
        // System.out.print("Welcome to the calendar program. To start, please enter the desired month as\na number from 1 to 12 followed by the year (ex:2021): ");
        // int userMonth = input.nextInt();
        // int userYear = input.nextInt();

        // while (userMonth < 1 || userMonth > 12) {
        //     System.out.print("Invalid month input. Please try again: ");
        //     userMonth = input.nextInt();
        // }

        // printMonthCalendar(userMonth,userYear);
        boolean checkYear = isLeapYear(1900);
        // int day = getStartDay(3,1,2004);
        System.out.println(checkYear);
    }


    /****
     The method getStartDay() implements Zeller's Algorithm for determining the day of the
    week the first day of a month is. The method adjusts Zeller's numbering scheme
    for day of week ( 0=Saturday, ..., 6=Friday ) to conform to a day of week number
    that corresponds to ISO conventions (i.e., 1=Monday, ..., 7=Sunday)
    
    Pre-Conditions: The month value, m,  is 1-12
                            The day value, d, is 1-31, or 1-28, 1-29 for February
                            The year value, y, is the full year (e.g., 2012)
                    
    Post-Conditions: A value of 1-7 is returned, representing the first day of the month
                            1 = Monday, ..., 7 = Sunday
    ****/

    public static int getStartDay( int m, int d, int y ) {
        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3) 
        {
            m = m + 12;
            y = y - 1;
        }
        
        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'
        
        h = ( d + ( 13 * ( m + 1 ) / 5 ) + k + ( k / 4 ) + ( j / 4 ) +
            ( 5 * j ) ) % 7;
        
        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ( ( h + 5 ) % 7 ) + 1;     
        
        return dayNum;
    }

    public static void printMonthCalendar(int m, int y) {
        printMonthHeader(m,y);
    }

    public static void printMonthHeader( int m, int y ) {
        String selectedMonthName = getMonthName(m);
        System.out.println("\t" + selectedMonthName + " " + y);
        for (int x = 0; x < 29; x++) {
            System.out.print("-");
        }
        System.out.println("\n Sun Mon Tue Wed Thu Fri Sat ");
        printMonthBody(m,y);
    }
    
    public static void printMonthBody(int m, int y) {
        System.out.println("   1   2   3   4   5   6   7");
    }

    public static String getMonthName( int m ) {
        String monthName = "January";
        switch (m) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Improper input detected. Please try again";
                break;
                
        }
        return monthName;
    }

    public static boolean isLeapYear( int y ) {
        int year = y;
        boolean divByFour = year % 4 == 0 ? true : false;
        boolean isCentury = year % 100 == 0 ? true : false;
        boolean fourHundredYearsCentury = year % 400 == 0 ? true : false;
        boolean leapYearBool = false;
        if (divByFour) {
            if (isCentury) {
                if (fourHundredYearsCentury) {
                    leapYearBool = true;
                } else {
                    leapYearBool = false;
                }
            } else {
                leapYearBool = true;
            }
        } else {
            leapYearBool = false;
        }
        return leapYearBool;
    }

    /*
    void printMonthCalendar( int m, int y ) 
    Displays a calendar like the one
    above for a specified month and
    year.

    void printMonthHeader( int m, int y ) 
    Displays the header information
    ( month, year, line separator, 3-
    character day names) for a calendar.

    void printMonthBody( int m, int y ) 
    Displays the days in the calendar
    associated with the corresponding
    days of the week.

    String getMonthName( int m ) 
    Returns the name of the month for a
    specified month number (e.g.,
    returns March for m=3).

    int getStartDay( int m, int d, int y ) 
    Returns the day of week number
    (1=Monday,…, 7= Sunday) for the
    specified month, day, and year. Note
    this only works for the 1st day of the
    month.

    int getNumDaysInMonth( int m, int y) 
    Returns the number of days in a
    specified month and year. Leap years
    are accounted for.
    boolean isLeapYear( int y )
    */

}