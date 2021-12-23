import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the RoundCounter class
 *
 * @author Erik Ciliano
 */
public class RoundCounterTest {

    /** RoundCounter object for testing */
    private RoundCounter testRoundCounter;

    /**
     * Sets up test object before each test
     */
    @BeforeEach
    public void setUp() {
        testRoundCounter = new RoundCounter();
    }

    /**
     * Tests getRoundNum
     */
    @Test
    public void testGetRoundNum() {
        assertEquals(0, testRoundCounter.getRoundNum(), "Testing getRoundNum");
    }

    /**
     * Tests incRound. Method is called multiple times and the round number is checked
     * after no calls, one call, and three calls
     */
    @Test
    public void testIncRound() {
        assertEquals(0, testRoundCounter.getRoundNum(), "Test that round counter is at 0");
        testRoundCounter.incRound();
        assertEquals(1, testRoundCounter.getRoundNum(), "Test that round counter has incremented");
        testRoundCounter.incRound();
        testRoundCounter.incRound();
        testRoundCounter.incRound();
        assertEquals(4, testRoundCounter.getRoundNum(), "Test that round counter has incremented");

    }

}
