import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Wheel class, a class which shouldn't even exist anymore but oh well
 *
 * @author Erik Ciliano
 */
public class WheelTest {

    /** Wheel object used for testing */
    private Wheel testWheel;

    /**
     * Sets up testing object
     */
    @BeforeEach
    public void setUp() {
        testWheel = new Wheel();
    }

    /**
     * Tests getValue
     */
    @Test
    public void testGetValue() {
        assertEquals(600, testWheel.getValue(0), "Tests getValue");
        assertEquals(0, testWheel.getValue(9), "Tests getValue");
        assertEquals(-1, testWheel.getValue(20), "Tests getValue");
    }



}
