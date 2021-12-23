import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test BankCalculator methods
 * @author Suzanne Balik
 * @author Rabin Paudel
 */
public class BankCalculatorTest {

    /** Used to compare double values in tests */
    public static final double DELTA = 0.005;

    /**
    * DELTS
    */

    @Test
    public void testCalculatePayment1() {

        assertEquals(64.24, BankCalculator.calculatePayment(2020,9,36), DELTA,
                     "BankCalculator.calculatePayment(2020,9,36)");

    }

    /**
    * testCalculatePayment2
    */

    @Test
    public void testCalculatePayment2() {

        assertEquals(214.02, BankCalculator.calculatePayment(2500,5,12), DELTA,
                     "BankCalculator.calculatePayment(2500,5,12)");
    }

    /**
    * testCalculatePayment3
    */

    @Test
    public void testCalculatePayment3() {
        assertEquals(184.58, BankCalculator.calculatePayment(4000,10,24), DELTA,
            "BankCalculator.calculatePayment(4000,10,24)");

    }

    /**
    * testCalculatePayment4
    */

    @Test
    public void testCalculatePayment4() {

        assertEquals(11.07, BankCalculator.calculatePayment(500,3,48), DELTA,
                     "BankCalculator.calculatePayment(500,3,48)");

    }

    /**
    * testCalculateAmountNoCompounding1
    */

    @Test
    public void testCalculateAmountNoCompounding1() {

        assertEquals(215.04, BankCalculator.calculateAmountNoCompounding(192,3,4), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(192,3,4)");

    }

    /**
    * testCalculateAmountNoCompounding2
    */

    @Test
    public void testCalculateAmountNoCompounding2() {

        assertEquals(1500.00, BankCalculator.calculateAmountNoCompounding(1000,5,10), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(1000,5,10)");

    }

    /**
    * testCalculateAmountNoCompounding3
    */

    @Test
    public void testCalculateAmountNoCompounding3() {

        assertEquals(822.25, BankCalculator.calculateAmountNoCompounding(299,7,25), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(299,7,25)");

    }

    /**
    * testCalculateAmountNoCompounding4
    */

    @Test
    public void testCalculateAmountNoCompounding4() {

        assertEquals(7692.30, BankCalculator.calculateAmountNoCompounding(1998,15,19), DELTA,
                     "BankCalculator.calculateAmountNoCompounding(1998,15,19)");

    }

    /**
    * testCalculateAmountMonthlyCompounding1
    */

    @Test
    public void testCalculateAmountMonthlyCompounding1() {

        assertEquals(152173.69, BankCalculator.calculateAmountMonthlyCompounding(56098,5,20), DELTA,
                    "BankCalculator.calculateAmountMonthlyCompounding(56098,5,20)");

    }

   /**
   * testCalculateAmountMonthlyCompounding2
   */

    @Test
    public void testCalculateAmountMonthlyCompounding2() {

        assertEquals(9726.97, BankCalculator.calculateAmountMonthlyCompounding(4599,3,25), DELTA,
                   "BankCalculator.calculateAmountMonthlyCompounding(4599,3,25)");

    }

  /**
  * testCalculateAmountMonthlyCompounding3
  */

    @Test
    public void testCalculateAmountMonthlyCompounding3() {

        assertEquals(17135.28, BankCalculator.calculateAmountMonthlyCompounding(9999,6,9), DELTA,
                  "BankCalculator.calculateAmountMonthlyCompounding(9999,6,9)");

    }

    /**
    * testCalculateAmountMonthlyCompounding4
    */

    @Test
    public void testCalculateAmountMonthlyCompounding4() {

        assertEquals(26413.77, BankCalculator.calculateAmountMonthlyCompounding(500,20,20), DELTA,
                 "BankCalculator.calculateAmountMonthlyCompounding(500,20,20)");

    }

    /**
    * testCalculateAmountContinuousCompounding1
    */

    @Test
    public void testCalculateAmountContinuousCompounding1() {

        assertEquals(2875.68, BankCalculator.calculateAmountContinuousCompounding(2500,2,7), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(2500,2,7)");

    }

    /**
    * testCalculateAmountContinuousCompounding2
    */

    @Test
    public void testCalculateAmountContinuousCompounding2() {

        assertEquals(1324.73, BankCalculator.calculateAmountContinuousCompounding(399,8,15), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(399,8,15)");

    }

    /**
    * testCalculateAmountContinuousCompounding3
    */

    @Test
    public void testCalculateAmountContinuousCompounding3() {

        assertEquals(1469.45, BankCalculator.calculateAmountContinuousCompounding(985,2,20), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(985,2,20)");

    }

    /**
    * testCalculateAmountContinuousCompounding4
    */

    @Test
    public void testCalculateAmountContinuousCompounding4() {

        assertEquals(3902.44, BankCalculator.calculateAmountContinuousCompounding(2750,7,5), DELTA,
                     "BankCalculator.calculateAmountContinuousCompounding(2750,7,5)");

    }


    /**
     * Test the BankCalculator methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(0,2,10),
                                           "BankCalculator.calculatePayment(0,2,10)");
        assertEquals("Invalid loan amount", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(0,2,10) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(5000,-2,10),
                                           "BankCalculator.calculatePayment(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(5000,-2,10) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculatePayment(1000,2,-1),
                                           "BankCalculator.calculatePayment(1000,2,-1)");
        assertEquals("Invalid number of months", exception.getMessage(),
                     "Testing BankCalculator.calculatePayment(1000,2,-1) - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(0,2,10),
                                           "BankCalculator.calculateAmountNoCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountNoCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountNoCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountNoCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountNoCompounding(1000,2,-1)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(0,2,10),
                    "BankCalculator.calculateAmountMonthlyCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountMonthlyCompounding(1000,2,-1)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(0,2,10),
                    "BankCalculator.calculateAmountContinuousCompounding(0,2,10)");
        assertEquals("Invalid deposit amount", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(0,2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(5000,-2,10),
                    "BankCalculator.calculateAmountContinuousCompounding(5000,-2,10)");
        assertEquals("Invalid interest rate", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(5000,-2,10)" +
                     " - exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> BankCalculator.calculateAmountContinuousCompounding(1000,2,-1),
                    "BankCalculator.calculateAmountContinuousCompounding(1000,2,-1)");
        assertEquals("Invalid number of years", exception.getMessage(),
                     "Testing BankCalculator.calculateAmountContinuousCompounding(1000,2,-1)" +
                     " - exception message");




    }
}
