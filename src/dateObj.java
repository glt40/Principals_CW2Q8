public class dateObj {

    // Initialise vars
    int day;
    int month;
    int year;
    int[] calendarStandard;
    int[] calendarLeap;
    boolean isLeap;

    /**
     * Constructor assigns day, month, year and builds both calendar arrays
     *
     * @param startD Initial day
     * @param startM Initial month
     * @param startY Initial year
     */
    public dateObj(int startD, int startM, int startY) {
        day = startD;
        month = startM;
        year = startY;
        // the calendar arrays tell the object how many days are in each month
        calendarStandard = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        calendarLeap = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    }

    public boolean isEqual(dateObj targetDate) {
        if (targetDate.day == this.day && targetDate.month == this.month && targetDate.year == this.year) {
            return true;
        } else {
            return false;
        }
    }

    public void printDate() {
        System.out.println(day + ", " + month + ", " + year);
    }

    /**
     * changes the value of day by 1, resets to 1 if end of month reached
     *
     * @return true if month has changed
     */
    private boolean nextDay() {
        day++;
        if (isLeap) {
            // use the Leap calendar
            if (day - 1 == calendarLeap[month - 1]) {
                // end of month reached
                day = 1;
                return true;
            } else {
                return false;
            }
        } else {
            // use the Standard calendar
            if (day - 1 == calendarStandard[month - 1]) {
                // end of month reached
                day = 1;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * changes the value of month by 1, resets to 1 if end of year reached
     *
     * @return true if year has changed
     */
    private boolean nextMonth() {
        month++;
        if (month == 13) {
            // end of year reached
            month = 1;
            return true;
        } else {
            return false;
        }
    }

    public void incrementDay() {
        // the day has to be decided first, then the month, then the year
        if (nextDay()) {
            if (nextMonth()) {
                // year has changed, so just add 1
                // unlike the day or month, year does not loop
                year++;
                // decide if the year is a leap year
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                    isLeap = true;
                } else {
                    isLeap = false;
                }
            }
        }
    }
}
