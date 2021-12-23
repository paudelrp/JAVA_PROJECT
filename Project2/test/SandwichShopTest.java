import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Program to test SandwichShop methods
 * @author Suzanne Balik
 * @author Michelle Glatz
 * @author
 */
public class SandwichShopTest {

    // TODO: Javadoc all methods to pass checkstyle tool. Reminder that magic numbers are allowed
    // in test program

    @Test
    public void testIsValidTimeAfternoonValid() {

        assertTrue(SandwichShop.isValidTime(2, 20), "SandwichShop.isValidTime(2, 20)");

    }

    @Test
    public void testIsValidTimeEveningInvalid() {




        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SandwichShop.isValidTime(7, 4),
                                     "SandwichShop.isWeekday(7, 4)");
        assertEquals("Invalid time", exception.getMessage() );

    }


    @Test
    public void testIsValidTimeMorningBorderValid() {

    // TODO: Replace the below code with an appropriate assert statement
        assertTrue(SandwichShop.isValidTime(11, 45), "SandwichShop.isValidTime(11, 45)");


    }

    @Test
    public void testIsValidTimeMorningBorderInvalid() {

    // TODO: Replace the below code with an appropriate assert statement


        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SandwichShop.isValidTime(10, 45),
                                     "SandwichShop.isWeekday(10, 45)");
        assertEquals("Invalid time", exception.getMessage() );


    }

    @Test
    public void testIsValidTimeNegativeMinute() {

    // TODO: Replace the below code with an appropriate assert statement


        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> SandwichShop.isValidTime(10, -45),
                                     "SandwichShop.isWeekday(10, -45)");
        assertEquals("Invalid time", exception.getMessage() );
    }


    @Test
    public void testIsValidDateMarchValid() {

        assertTrue(SandwichShop.isValidDate(3, 20), "SandwichShop.isValidDate(3, 20)");

    }

    @Test
    public void testIsValidDateDecember() {

        assertFalse(SandwichShop.isValidDate(12, 4), "SandwichShop.isValidDate(12, 4)");

    }


    @Test
    public void testIsValidDateMarchInvalid() {

    // TODO: Replace the below code with an appropriate assert statement
        assertTrue(SandwichShop.isValidDate(3, 31), "SandwichShop.isValidDate(3, 31)");

    }

    @Test
    public void testIsValidDateMayBorderValid() {

    // TODO: Replace the below code with an appropriate assert statement
        assertFalse(SandwichShop.isValidDate(3, 14), "SandwichShop.isValidDate(3, 15)");
    }

    @Test
    public void testIsValidDateAprilInvalidDay() {

    // TODO: Replace the below code with an appropriate assert statement
        assertTrue(SandwichShop.isValidDate(4, 20), "SandwichShop.isValidDate(4, 20)");

    }

    @Test
    public void testIsWeekdayMayThursday() {

        assertTrue(SandwichShop.isWeekday(5, 6), "SandwichShop.isWeekday(5, 6)");

    }

    @Test
    public void testIsWeekdayMarchSaturday() {

        assertFalse(SandwichShop.isWeekday(3, 27), "SandwichShop.isWeekday(3, 27)");

    }


    @Test
    public void testIsWeekdayAprilFriday() {

    // TODO: Replace the below code with an appropriate assert statement
        assertFalse(SandwichShop.isWeekday(4, 16), "SandwichShop.isWeekday(4, 16)");

    }

    @Test
    public void testIsWeekdayAprilMonday() {

    // TODO: Replace the below code with an appropriate assert statement
        assertTrue(SandwichShop.isWeekday(4, 12), "SandwichShop.isWeekday(4, 12)");

    }

    @Test
    public void testIsWeekdayMaySundayValid() {

    // TODO: Replace the below code with an appropriate assert statement
        assertFalse(SandwichShop.isWeekday(5, 23), "SandwichShop.isWeekday(5, 23)");

    }

    @Test
    public void testGetOrderCostOneChicken() {
        assertEquals(450, SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0),
                     "SandwichShop.getOrderCost(1, 0, 0, 0, 0, 0)");

    }


    @Test
    public void testGetOrderCostTwoBurgers() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(950, SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0),
                 "SandwichShop.getOrderCost(0, 2, 0, 0, 0, 0)");

    }

    @Test
    public void testGetOrderCostOneVeggieOneWater() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(520, SandwichShop.getOrderCost(0, 0, 1, 1, 0, 0),
                 "SandwichShop.getOrderCost(0, 0, 0, 1, 1, 0)");

    }

    @Test
    public void testGetOrderCostThreeCoffees() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(585, SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0),
                 "SandwichShop.getOrderCost(0, 0, 0, 0, 3, 0)");

    }


    @Test
    public void testGetOrderCostOneShake() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(255, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1),
                 "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 1)");

    }

    @Test
    public void testGetOrderCostNothing() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(0, SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0),
                 "SandwichShop.getOrderCost(0, 0, 0, 0, 0, 0)");

    }

    @Test
    public void testGetOrderCostOneOfEverything() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals(1895, SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1),
                 "SandwichShop.getOrderCost(1, 1, 1, 1, 1, 1)");

    }

    @Test
    public void testGetPickupTimeWeekdayEvening() {
        assertEquals("6:20", SandwichShop.getPickupTime(3, 23, 6, 5),
                     "SandwichShop.getPickupTime(3, 23, 6, 5)");

    }


    @Test
    public void testGetPickupTimeWeekdayLatestOrderTime() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals("6:45", SandwichShop.getPickupTime(3, 24, 6, 30),
                 "SandwichShop.getPickupTime(3, 24, 6, 44)");

    }

    @Test
    public void testGetPickupTimeWeekendTwelveThirtyOrderTime() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals("1:00", SandwichShop.getPickupTime(3, 21, 12, 30),
                 "SandwichShop.getPickupTime(3, 21, 12, 30)");

    }

    @Test
    public void testGetPickupTimeWeekendMorning() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals("11:35", SandwichShop.getPickupTime(4, 11, 11, 05),
                 "SandwichShop.getPickupTime(3, 6, 7, 00)");

    }


    @Test
    public void testGetPickupTimeWeekdayTwoFiftyTwoOrderTime() {

    // TODO: Replace the below code with an appropriate assert statement
    assertEquals("2:50", SandwichShop.getPickupTime(4, 8, 2, 35),
                 "SandwichShop.getPickupTime(4, 8, 2, 35)");
    }

    @Test
    public void testGetPickupTimeWeekendSixThirtyOrderTime() {

    assertEquals("6:00", SandwichShop.getPickupTime(4, 25, 5, 30));

    }


    /**
     * Test the SandwichShop methods with invalid values
     */
    @Test
    public void testInvalidMethods() {

        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!

        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.isWeekday(2, 27),
                                 "SandwichShop.isWeekday(2, 27)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.isWeekday(2, 27) - " +
                     "exception message");
        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1),
                                           "SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(-1, 2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(2, -2, 3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1),
                                 "SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(0, 2, -3, 4, 0, 1) - exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, -3, 0, 1) - " +
                     "exception message");


        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, -1, 1) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3),
                                 "SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3)");
        assertEquals("Invalid amount", exception.getMessage(),
                     "Testing SandwichShop.getOrderCost(1, 2, 3, 4, 1, -3) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(1, 15, 3, 20),
                                 "SandwichShop.getPickupTime(1, 15, 3, 20)");
        assertEquals("Invalid date", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(1, 15, 3, 20) - " +
                     "exception message");

        exception = assertThrows(IllegalArgumentException.class,
            () -> SandwichShop.getPickupTime(4, 10, 8, 30),
                                 "SandwichShop.getPickupTime(4, 10, 8, 30)");
        assertEquals("Invalid time", exception.getMessage(),
                     "Testing SandwichShop.getPickupTime(4, 10, 8, 30) - " +
                     "exception message");


    }
}
