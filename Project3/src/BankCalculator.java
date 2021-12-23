import java.util.Scanner;
/**
 * Bank Calculator program is the loan payment amounts.
 *
 * @author Rabin Paudel
 *
 */

public class BankCalculator {
    /**
    * TWELVE
    */

    public static final int TWELVE = 12;

     /**
     * TWELVE_HUNDRED
     */

    public static final int TWELVE_HUNDRED = 1200;

      /**
      * ONE_HUNDRED_DOUBL
      */

    public static final double DOUBL_ONE_HUNDRED = 100.00;

          /**
          * SEVENTY_TWO
          */
    public static final int ONE_HUNDRED = 100;

        /**
        * SEVENTY_TWO
        */


    public static final int SEVENTY_TWO = 72;

    /**
     * Starts Project with class BankCalculator*
     * @author Rabin Paudel
     *
     * Takes user input to determine different values of SandwichShop.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        Scanner scnr = new Scanner (System.in);
        System.out.println("Bank Calculator - Please choose an option.\n");
        System.out.println("L - Loan\r\n" + "D - Deposit\r\n" + "Q - Quit\n");
        System.out.print("Option: \n");
        String se = scnr.nextLine();
        char value;
        value = se.charAt(0);
        if (se.length() > 1) {
            System.out.print("Invalid option");
            System.exit(1);
        }
        switch(value) {
            case 'L':
            case 'l':
                break;
            case 'D':
            case 'd':
                break;
            case 'Q':
            case 'q':
                System.exit(1);
                break;
            default: System.out.println ("Invalid shape");
                System.exit(1);
        }
        System.out.print("Amount: \n");
        while (!scnr.hasNextInt()) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.println();
        int amount = scnr.nextInt();
        if (amount <= 0) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        if (value == 'L' || value == 'l') {
            System.out.print("Minimum interest rate: \n");
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid value");
                System.exit(1);
            }
            System.out.println();
            int min = scnr.nextInt();
            if (min <= 0) {
                System.out.print("Invalid value");
                System.exit(1);
            }
            System.out.print("Maximum interest rate: \n");
            while (!scnr.hasNextInt()) {
                System.out.print("Invalid value");
                System.exit(1);
            }
            System.out.println();
            int max = scnr.nextInt();
            if (max <= 0) {
                System.out.print("Invalid value");
                System.exit(1);
            }
            if (min > max) {
                System.out.print("Invalid value");
                System.exit(1);
            }
            System.out.println("                      Monthly Payment\n");
            System.out.printf("%-12s%-17s%-17s%-16s%-16s%-16s%-18s\n", "Interest", "12 mos",
                "24 mos", "36 mos", "48 mos", "60 mos", "72 mos");
            System.out.printf("%-12s%-17s%-17s%-16s%-16s%-16s%-18s\n", "------", "------",
                "------", "------", "------", "------", "------");
            for (int i = min; i <= max; i++) {
                System.out.print(" " + i + "%");
                for (int j = TWELVE; j <= SEVENTY_TWO; j = j + TWELVE) {
                    System.out.printf( " %15.2f", calculatePayment(amount,i,j));
                }
                System.out.println();
            }
            System.exit(1);
        }
        System.out.print("Years: \n");
        while (!scnr.hasNextInt()) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.println();
        int years = scnr.nextInt();
        if (years <= 0) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.print("Minimum interest rate: \n");
        while (!scnr.hasNextInt()) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.println();
        int min = scnr.nextInt();
        if (min <= 0) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.print("Maximum interest rate: \n");
        while (!scnr.hasNextInt()) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        System.out.println();
        int max = scnr.nextInt();
        if (max <= 0) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        if (min > max) {
            System.out.print("Invalid value");
            System.exit(1);
        }
        if ( value == 'D' || value == 'd') {
            System.out.println("                      Final Amount \n");
            System.out.printf("%-14s%-22s%-19s%-17s\n", " ", "No", "Monthly", "Continuous");
            System.out.printf("%-14s%-20s%-20s%-17s\n", "Interest", "Compounding", "Compounding",
                "Compounding");
            System.out.printf("%-14s%-20s%-20s%-17s\n", "--------", "-----------", "-----------",
                "-----------");
            for (int i = min; i <= max; i++) {
                System.out.printf( "%s%%% 20.2f% 20.2f% 20.2f\n", i,
                    calculateAmountNoCompounding (amount,i,years),
                    calculateAmountMonthlyCompounding (amount,i,years)
                    , calculateAmountContinuousCompounding (amount,i,years));
            }
            System.out.println();
        }
    }

    /**
    * We must check for invalid parameters (arguments) in the order given above.
    * Calculates and returns monthly payment amount using formula given above
    * This method must NOT output any value(s)
    * @param loanAmount int values
    * @param annualInterestRate int values
    * @param numberOfMonths int values
    * @return calculatePaymen
    * @throws IllegalArgumentException "Invalid loan amount" if loan amounts less zero
    * @throws IllegalArgumentException "Invalid interest rate if annualInterestRate less zero
    * @throws IllegalArgumentException "Invalid number of months" if numberOfMonths less zero
    */

    public static double calculatePayment(int loanAmount, int annualInterestRate,
            int numberOfMonths) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Invalid loan amount");
        }
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (numberOfMonths <= 0) {
            throw new IllegalArgumentException("Invalid number of months");
        }
        double calculatePaymen = 0;
        double monthyInterestRate = 0;
        monthyInterestRate = (double) annualInterestRate / TWELVE_HUNDRED;
        double total = (double) (loanAmount * monthyInterestRate * Math.pow((1 + monthyInterestRate)
            , numberOfMonths));
        double total1 = (double)(Math.pow((1 + monthyInterestRate), numberOfMonths) - 1);
        calculatePaymen = (double)(total / total1);
        return calculatePaymen;


    }
    /**
    * We must check for invalid parameters (arguments) in the order given above.
    * Calculates and returns final amount of deposit with no compounding of interest
    * using formula given above
    * NOTE: This method must NOT output any value(s)
    * @param depositAmount int values
    * @param annualInterestRate int values
    * @param numberOfYears int values
    * @return final amount
    * @throws IllegalArgumentException "Invalid deposit amount" if amounts less zero
    * @throws IllegalArgumentException "Invalid interest rate" if InterestRate less zero
    * @throws IllegalArgumentException "Invalid number of years" if Invalid numbers less zero
    */

    public static double calculateAmountNoCompounding(int depositAmount,
        int annualInterestRate, int numberOfYears) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Invalid number of years");
        }
        double finalAmount = 0;
        finalAmount = (double)(depositAmount * (1 + (double)(annualInterestRate *
            numberOfYears) / ONE_HUNDRED));
        return finalAmount;

    }

    /**
    * we must check for invalid parameters (arguments) in the order given above.
    * Calculates and returns final amount of deposit with monthly compounding of interest
    * using formula given above
    * This method must NOT output any value(s)
    * @param depositAmount int values
    * @param annualInterestRate int values
    * @param numberOfYears int values
    * @return perodicCom
    * @throws IllegalArgumentException "Invalid deposit amount" if amounts less zero
    * @throws IllegalArgumentException "Invalid interest rate" if InterestRate less zero
    * @throws IllegalArgumentException "Invalid number of years" if Invalid numbers less zero
    */

    public static double calculateAmountMonthlyCompounding(int depositAmount,
        int annualInterestRate, int numberOfYears) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Invalid number of years");
        }
        double perodicCom = 0;
        double interestRate = 0;
        double to2 = 0;
        double tot1 = 0;
        tot1 = numberOfYears * TWELVE;
        interestRate = (double)annualInterestRate / ONE_HUNDRED ;
        double ratio = interestRate / TWELVE ;
        to2 = (Math.pow((1 + ratio), tot1));
        perodicCom = depositAmount * to2;
        perodicCom = Math.round(perodicCom * DOUBL_ONE_HUNDRED) / DOUBL_ONE_HUNDRED;
        return perodicCom;

    }
    /**
    * We must check for invalid parameters (arguments) in the order given above.
    * Calculates and returns final amount of deposit with continuous compounding of interest
    * using formula given above
    * This method must NOT output any value(s)
    * @param depositAmount int values
    * @param annualInterestRate int values
    * @param numberOfYears int values
    * @return conComInterest
    * @throws IllegalArgumentException "Invalid deposit amount" if amounts less zero
    * @throws IllegalArgumentException "Invalid interest rate" if InterestRate less zero
    * @throws IllegalArgumentException "Invalid number of years" if Invalid numbers less zero
    */

    public static double calculateAmountContinuousCompounding(int depositAmount,
        int annualInterestRate, int numberOfYears) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Invalid interest rate");
        }
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Invalid number of years");
        }
        double conComInterest = 0;
        double annuInt = 0;
        annuInt = (double) annualInterestRate / ONE_HUNDRED;
        conComInterest = (double)(depositAmount * Math.exp(numberOfYears * annuInt));
        return conComInterest;
    }
}
