import java.util.Scanner;

/**
 * This project must prompt understanding basic concept of if else-if statement
 * and using method.
 *
 * @author Rabin Paudel
 *
 */

public class SandwichShop {

    /**
     * Starts Project with class SandwichShop*
     * @author Rabin Paudel
     *
     * Takes user input to determine different values of SandwichShop.
     *
     * @param args command line arguments
     */
    public static final int HOUR_ELE = 11;
     /**
     * HOUR_ELE
     */

    public static final int SEVEN = 7;

     /**
     * FOURTEEN
     */
    public static final int HOUR_TWE = 12;
     /**
     * HOUR_TWE
     */

    public static final int HOUR_FOUR = 4;
     /**
     * HOUR_FOUR
     */

    public static final int HOUR_FIVE = 5;
     /**
     * HOUR_FIVE
     */

    public static final int HOUR_SIX = 6;
     /**
     * HOUR_FIVE
     */

    public static final int TEN = 10;

     /**
     * TEN
     */

    public static final int DAY_FIFT = 15;

    /**
    * HOUR_FIVE
    */

    public static final int DAY_THIRTYO = 31;

    /**
    * HOUR_SIX
    */

    public static final int ONE_HUNDRED = 100;

    /**
    * FOUR_HUNDRED
    */

    public static final int HOUR_FNINE = 59;

    /**
    * Initiates the program and asks for user input.
    *
    * @param args command line arguments
    */

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.print("                 Welcome to the Wolfpack Sandwich Shop!");
        System.out.print("Orders mustbe placed between 11:00 AM and 6:59 PM on March 15 - May 31.");
        System.out.print("When prompted, please enter the time and date.You will then be asked to");
        System.out.print("enter the number of each sandwich/beverage you would like to purchase -");
        System.out.print("Chicken Supreme, Burger Bonanza,Veggie Delite, Water, Coffee, Chocolate");
        System.out.print("Shake. Your order cost and estimated pickup time will then be output.");


        System.out.print("Please enter time (hour min, eg. 4 59): ");
        int hour = scnr.nextInt();
        int minute = scnr.nextInt();

        if (hour < 0 || hour > HOUR_TWE) {
            System.out.println("Invalid time");
            System.exit(1);
        } else {
            if (hour >= SEVEN && hour <= TEN) {
                System.out.println("Invalid time");
                System.exit(1);
            }
        }
        if (minute < 0 || minute > HOUR_FNINE) {
            System.out.println("Invalid time");
            System.exit(1);
        }

        System.out.print("Please enter date (month day, eg. 3 25): ");

        int month = scnr.nextInt();
        int day = scnr.nextInt();

        if ((month != 3) || (day < DAY_FIFT || day > DAY_THIRTYO)) {
            System.out.println("Invalid date");
            System.exit(1);
        }
        if ((month < HOUR_FOUR || month > HOUR_SIX) || (day < 1 || day > DAY_THIRTYO)) {
            System.out.println("Invalid date");
            System.exit(1);
        }

        System.out.println("Please enter the number of each sandwich/ beverage that you");
        System.out.println("would like to purchage:");
        System.out.println("Chicken Supreme: ");
        int chi = scnr.nextInt();
        if (chi < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        System.out.println("Burger Bonanza:  ");
        int bur = scnr.nextInt();
        if (bur < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        System.out.println("Veggie Delit: ");
        int veg = scnr.nextInt();
        if (veg < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        System.out.println("Water: ");
        int wat = scnr.nextInt();
        if (wat < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        System.out.println("Coffee ");
        int coff = scnr.nextInt();
        if (coff < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        System.out.println("Chocolate Shake: ");
        int choc = scnr.nextInt();
        if (choc < 0) {
            System.out.println("Invalid amount");
            System.exit(1);
        }
        if (chi == 0 && bur == 0 && veg == 0 && wat == 0 && coff == 0 && choc == 0) {
            int total = chi + bur + veg + wat + coff + choc;
            System.out.println("Cost of order: $%4.02d" + total);
            System.exit(1);
        }
        System.out.println("Cost of order: " + "$" +
            getOrderCost(chi, bur, veg, wat, coff, choc) / ONE_HUNDRED + "."
            + getOrderCost(chi, bur, veg, wat, coff, choc) % ONE_HUNDRED);

        System.out.println("Estimated Pickup Time:" + getPickupTime(hour, minute, month, day));
    }

        /**
        * CHICKEN
    */

    public static final double CHICKEN = 450;

    /**
    * CHICKEN
    */

    public static final double BURGER = 475;

    /**
    * BURGER
    */
    public static final double VEGGIE = 395;

    /**
    * VEGGIE
    */
    public static final double WATER = 125;

    /**
    * WATER
    */
    public static final double COFFEE = 195;

    /**
    * COFFEE
    */
    public static final double CHOCOLATE = 255;

    /**
    * CHOCOLATE
    */
    public static final int YEAR = 2021;

    /**
    * CHOCOLATE
    */
    public static final int FOURTEEN = 14;

    /**
    * FOUR_HUNDRED
    */
    public static final int FOUR_HUNDRED = 400;

    /**
    * Returns true, if hour is a value ranging from 11 to 12 or 1 to 6 and min is a
    * value from 0 to 59 You may assume that the hour represents 11 AM, 12 NOON, or
    * 1 - 6 PM. Returns false, otherwise
    *
    * @param hour   boolean value to find in String
    * @param minute boolean value to find in String
    * @return false and true
    * @throws IllegalArgumentException with message "Invalid Time" int minute
    * and houes.
    */

    public static boolean isValidTime(int hour, int minute) {
        if (hour < 0 || hour > HOUR_TWE || minute < 0 || minute > HOUR_FNINE) {
            throw new IllegalArgumentException("Invalid time");
        } else {
            if (hour >= SEVEN && hour <= TEN) {
                throw new IllegalArgumentException("Invalid time");
            } else {
                return true;
            }
        }
    }

    /**
    * Returns true, if the month and day represent a date that is between March 15
    * and May 31, inclusive. Returns false, otherwise
    *
    * @param month int values
    * @param day   int value to find in String
    * @return false and true
    */

    public static boolean isValidDate(int month, int day) {
        if ((month == 3) && (day >= DAY_FIFT && day <= DAY_THIRTYO)) {
            return true;
        } else if ((month >= HOUR_FOUR && month <= HOUR_SIX) && (day >= 1 && day <= DAY_THIRTYO)) {
            return true;
        } else {
            return false;
        }
    }

    /**
    * Throws an IllegalArgumentException with the message, "Invalid date", if the
    * month and day do not represent date that is between March 15 and May
    * 31,inclusive. HINT: Use the isValidDate() method to determine this. This
    * method must use Zeller's Algorithm as described in the Implementation section
    * below. Returns true, if the date falls on Monday - Thursday in 2021 Returns
    * false, otherwise
    *
    * @param month int values
    * @param day   int values
    * @return false and true
    */

    public static boolean isWeekday(int month, int day) {
        boolean weekDay = isValidDate(month, day);
        if (!weekDay) {
            throw new IllegalArgumentException("Invalid date");
        }
        if (weekDay == true) {
            int w = YEAR - (FOURTEEN - month) / HOUR_TWE;
            int x = w + w / HOUR_FOUR - w / ONE_HUNDRED + w / FOUR_HUNDRED;
            int z = month + HOUR_TWE * ((FOURTEEN - month) / HOUR_TWE) - 2;
            int y = (day + x + (DAY_THIRTYO * z) / HOUR_TWE) % SEVEN;
            if (y > 0 && y < HOUR_FIVE) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
    * Throws an IllegalArgumentException with the message, "Invalid amount", if any
    * parameter value is negative Returns the cost of the order for the given
    * number of each item, as specified above, as an integer number of cents
    *
    * @param chicken burger veggie water int values
    * @param coffee  int values
    * @param burger  int values
    * @param veggie  int values
    * @param water   int values
    * @param shake   int values
    * @return test int values
    * @throws IllegalArgumentException with message "Invalid elements" if size of
    *                                  chiken
    */

    public static int getOrderCost(int chicken, int burger,
        int veggie, int water, int coffee, int shake) {
        if (chicken < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (burger < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (veggie < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (water < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (coffee < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (shake < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        int test = 0;
        test = (int) (chicken * CHICKEN + burger * BURGER +
            veggie * VEGGIE + water * WATER + coffee * COFFEE
            + shake * CHOCOLATE);
        return test;
    }

        /**
        * SIXTY
        */
    public static final int SIXTY = 60;
        /**
        * SIXTY
        */

    public static final int FIFTEEN = 15;

        /**
        * FIFTEEN
        */

    public static final int THIR_TEEN = 13;

        /**
        * THIR_TEEN
        */
    public static final int THIRTY = 30;

        /**
        * Throws an IllegalArgumentException with the message, "Invalid date", if the
        * date is invalid HINT: Use the isValidDate() method to determine this Throws
        * an IllegalArgumentException with the message, "Invalid time", if the time is
        * invalid HINT: Use the isValidTime() method to determine this Determines and
        * returns the pickup time as a String in which the hour and minutes are
        * separated by a colon (:) and minute values that are less than 10 are preceded
        * by a 0. For example, "3:05", "12:29", etc. HINT: Use the isWeekday() method
        * to determine whether the date falls on weekday.
        *
        * @param hour  int values
        * @param min   int values
        * @param month int values
        * @param day   int values
        * @return values int values
        * @throws new IllegalArgumentException ("Invalid time")
        */

    public static String getPickupTime(int month, int day, int hour, int min) {

        boolean ght = isValidTime(hour, min);
        if (!ght) {
            throw new IllegalArgumentException("Invalid time");
        }

        boolean validDate = isValidDate(month, day);
        if (!validDate) {
            throw new IllegalArgumentException("Invalid date");
        }
        String st = "";
        boolean sti = isWeekday(month, day);
        if (sti == true) {
            st = addMinute(hour, min, FIFTEEN);
        }
        st = addMinute(hour, min, THIRTY);
        return st;
    }

    /**
    * create new method addMinute
    * @param hour int values
    * @param minute int values
    * @param minutetoAdd int values
    * @return values String values
    *
    */

    public static String addMinute(int hour, int minute, int minutetoAdd) {
        int min = hour * SIXTY + minute + minutetoAdd;
        int h = min / SIXTY;
        if (h > HOUR_TWE) {
            h = h - HOUR_TWE;
        }
        int m = min % SIXTY;
        return String.format("%d:%02d", h, m);
    }
}
