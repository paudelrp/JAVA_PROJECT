import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests SlotMachine class
 *
 * @author Suzanne Balik
 * @author Rabin Paudel
 */

public class SlotMachineTest {

    /**
    * SlotMachine
    */

    private SlotMachine sm;

    /**
    * setup
    */

    @BeforeEach
    public void setUp() {
        sm = new SlotMachine(0);
    }

    /**
    * public testConstant
    */

    @Test
    public void testConstant() {
        assertEquals(5, SlotMachine.BET_AMOUNT, "BET_AMOUNT");
    }

    /**
    * testConstructor
    */

    @Test
    public void testConstructor() {
        assertEquals(50, sm.getNumberOfTokens(), "Tokan is Initialized to 50.");
        assertEquals(0, sm.getCurrentIndexOfReel(0), "Index of Current Reel. ");
        assertEquals("Pull Lever To Begin", sm.getStatus(),
            "Initial Status of the SlotMachine.");
        assertEquals(0, sm.getCurrentIndexOfReel(1), "Index of Current Reel");
        assertEquals(0, sm.getCurrentIndexOfReel(2), "Index of Current Reel");

    }

    /**
    * testMakeBetSingleBet
    */

    @Test
    public void testMakeBetSingleBet() {
        sm.makeBet();
        assertEquals(45, sm.getNumberOfTokens(), "Initial bet");
    }

    /**
    * testMakeBetMultipleBet
    */

    @Test
    public void testMakeBetMultipleBet() {
        sm.makeBet();
        assertEquals(45, sm.getNumberOfTokens(), "Initial bet");
        sm.makeBet();
        assertEquals(40, sm.getNumberOfTokens(), "Second bet");
        sm.makeBet();
        assertEquals(35, sm.getNumberOfTokens(), "Second bet");
        sm.makeBet();
        assertEquals(30, sm.getNumberOfTokens(), "Second bet");

    }

    /**
     * Tests that exception is thrown for makeBet when no tokens are left
     */

    @Test
    public void testMakeBetException() {
        for (int i = 1; i <= 10; i++) {
            sm.makeBet();
        }
        Exception exception = assertThrows(IllegalStateException.class, () -> sm.makeBet(),
                                           "Not enough tokens for bet");
        assertEquals("Not enough tokens for bet", exception.getMessage(),
                     "Not enough tokens for bet - exception message");
    }

    /**
    * testTurnReelOnce
    */

    @Test
    public void testTurnReelOnce() {
        sm.turnReel();
        assertEquals(1, sm.getCurrentIndexOfReel(0), "Reel 0");
        assertEquals(0, sm.getCurrentIndexOfReel(1), "Reel 1");
        assertEquals(0, sm.getCurrentIndexOfReel(2), "Reel 2");
    }

    /**
    * testTurnReelOnce1
    */

    @Test
    public void testTurnReelOnce1() {
        sm.turnReel();
        assertEquals(0, sm.getCurrentIndexOfReel(1), "Reel 1");
        assertEquals(1, sm.getCurrentIndexOfReel(0), "Reel 0");
        assertEquals(0, sm.getCurrentIndexOfReel(2), "Reel 2");
    }

    /**
    * testDetermineOutcomeOnce
    */

    @Test
    public void testDetermineOutcomeOnce() {
        sm.determineOutcome();
        assertEquals(100, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols!50 Tokens!", sm.getStatus(), "Status");
    }

    /**
    * testDetermineOutcomeTwice
    */

    @Test
    public void testDetermineOutcomeTwice() {
        sm.determineOutcome();
        assertEquals(100, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols!50 Tokens!", sm.getStatus(), "Status");

        sm.determineOutcome();
        assertEquals(150, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols!50 Tokens!", sm.getStatus(), "Status");

        sm.determineOutcome();
        assertEquals(200, sm.getNumberOfTokens(), "Tokens");
        assertEquals("3 State Symbols!50 Tokens!", sm.getStatus(), "Status");

        sm.turnReel();
        sm.determineOutcome();
        assertEquals(220, sm.getNumberOfTokens(), "Tokens");
        assertEquals("2 State Symbols!20 Tokens!", sm.getStatus(), "Status");

        sm.turnReel();
        sm.determineOutcome();
        assertEquals(220, sm.getNumberOfTokens(), "Tokens");
        assertEquals("You Lose", sm.getStatus(), "Status");
    }
}
