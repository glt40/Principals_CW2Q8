public class ProjectEuler {

    // Initialise var
    dateObj dateCounter;

    /**
     * Constructor
     */
    public ProjectEuler(int startD, int startM, int startY) {
        dateCounter = new dateObj(startD, startM, startY);
    }

    /**
     * This method is called by main and runs a loop that checks each day for matching properties
     *
     * @return number of Tuesday the 1sts that occur between start and end dates
     */
    public int run() {
        // The calculation includes the start date but not the end date
        dateObj dateEnd = new dateObj(31, 12, 2000);
        // i counts the number of days elapsed, tuesFirstCount counts Tuesdays on the 1st of the month
        int i = 0;
        int tuesFirstCount = 0;
        while (!dateCounter.isEqual(dateEnd)) {
            i++;
            // dateCounter.printDate();
            // if condition satisfied if day is first of the month AND day is a Tuesday
            // the modulo division works logically here because the start date is a Tuesday
            // if you wanted to count the number of Wednesday the 20ths, only this condition would need changing
            if (dateCounter.day == 1 && i % 7 == 1) {
                tuesFirstCount++;
            }
            dateCounter.incrementDay();
        }
        return tuesFirstCount;
    }

    /**
     * Main method, created a new ProjectEuler object and then calls run to complete the calculation
     * Also prints the answer
     */
    public static void main(String[] args) {
        ProjectEuler project = new ProjectEuler(1, 1, 1901);
        System.out.println("Between 01/01/1901 and 31/12/2000 there were " + project.run() + " Tuesdays on the first of the month.");
    }
}
