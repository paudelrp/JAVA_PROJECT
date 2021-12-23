import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Round class
 *
 * @author Erik Ciliano
 */
public class RoundTest {

    /** Round object used for testing */
    private Round testRound;

    /** Puzzle object used for the creation of Round */
    private Puzzle puzzle;

    /** String constant for the category */
    public static final String CATEGORY = "RESTAURANTS";

    /** String constant for the phrase */
    public static final String PHRASE = "WAFFLE HOUSE";

    /** Array of chars representing what the blank puzzle array should look like */
    private char[] blanks = {'_', '_', '_', '_', '_', '_', ' ', '_', '_', '_', '_', '_'};

    /** Array of chars representing what the solved puzzle array should look like */
    private char[] solved = {'W', 'A', 'F', 'F', 'L', 'E', ' ', 'H', 'O', 'U', 'S', 'E'};

    /** Array of chars representing the default letters array after a round object is created */
    private char[] letters;

    /**
     * Sets up the test objects and fields before each test
     */
    @BeforeEach
    public void setUp() {
        puzzle = new Puzzle(CATEGORY, PHRASE);
        testRound = new Round(1, puzzle);
        letters = new char[26];
        for (int i = 0; i < letters.length; ++i) {
            this.letters[i] = ' ';
        }
    }

    /**
     * Tests the getRound method
     */
    @Test
    public void testGetRound() {
        assertEquals(1, testRound.getRound(), "Tests the getRound method");
    }

    /**
     * Test the getPuzzle method
     */
    @Test
    public void testGetPuzzle() {
        assertEquals(puzzle, testRound.getPuzzle(), "Tests the getPuzzle method");
    }

    /**
     * Tests the getBlanks method
     */
    @Test
    public void testGetBlanks() {
        assertArrayEquals(blanks, testRound.getBlanks(), "Tests the getBlanks method");
    }

    /**
     * Test the setRound method using getRound to check that the round number has been updated
     */
    @Test
    public void testSetRound() {
        assertEquals(1, testRound.getRound(), "Checks testRound's initial round value");
        testRound.setRound(2);
        assertEquals(2, testRound.getRound(), "Tests that set round has changed the round value");
    }

    /**
     * Tests the getLetters method
     */
    @Test
    public void testGetLetters() {
        assertArrayEquals(letters, testRound.getLetters(), "Tests the getLetters method");
    }

    /**
     * Tests the updateLetters method
     */
    @Test
    public void testUpdateLetters() {
        letters[0] = 'A';
        testRound.updateLetters('A');
        assertArrayEquals(letters, testRound.getLetters(), "Test the updateLetters method");
    }

    /**
     * Tests the ifLetterUsed method
     */
    @Test
    public void testIfLetterUsed() {
        assertFalse(testRound.ifLetterUsed('A'), "Should return false with no added letters");
        testRound.updateLetters('A');
        assertTrue(testRound.ifLetterUsed('A'), "Should return true after a letter is added");
    }

    /**
     * Tests the resetLetters array by updating letters, then calling resetLetters, then
     * comparing the blank letters array in testing to testRound's current letters array
     */
    @Test
    public void testResetLetters() {
        testRound.updateLetters('A');
        testRound.resetLetters();
        assertArrayEquals(letters, testRound.getLetters(),
                          "Tests that round's letter array is blank");
    }

    /**
     * Test the inputCharBlanks method by adding 'W'
     */
    @Test
    public void testInputCharBlanks() {
        blanks[0] = 'W';
        assertEquals(1, testRound.inputCharBlanks('W'), "Tests that only 1 character was added");
        assertArrayEquals(blanks, testRound.getBlanks(), "Tests that blanks has been updated");
    }

    /**
     * Tests the solveBlanks method
     */
    @Test
    public void testSolveBlanks() {
        testRound.solveBlanks();
        assertArrayEquals(solved, testRound.getBlanks(),
                          "Tests that blanks now has the solved puzzle");
    }

    /**
     * Tests the isSolved method by first checking again that solveBlanks works, and if it does,
     * then it asserts that isSolved should return true
     */
    @Test
    public void testIsSolved() {
        testRound.solveBlanks();
        assertArrayEquals(solved, testRound.getBlanks(), "Checks if blanks has the solved puzzle");
        assertTrue(testRound.isSolved(), "If blanks has the solved puzzle this should be true");
    }

}
