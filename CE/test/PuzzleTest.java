import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Puzzle class
 *
 * @author Erik Ciliano
 */
public class PuzzleTest {

    /** Puzzle object for testing */
    private Puzzle testPuzzle;

    /** String constant for the category */
    public static final String CATEGORY = "RESTAURANTS";

    /** String constant for the phrase */
    public static final String PHRASE = "WAFFLE HOUSE";

    /**
     * Sets up the puzzle object before each test
     */
    @BeforeEach
    public void setUp() {
        testPuzzle = new Puzzle(CATEGORY, PHRASE);
    }

    /**
     * Tests the getCategory method
     */
    @Test
    public void testGetCategory() {
        assertEquals(CATEGORY, testPuzzle.getCategory(), "Tests getCategory");
    }

    /**
     * Tests the getPhrase method
     */
    @Test
    public void testGetPhrase() {
        assertEquals(PHRASE, testPuzzle.getPhrase(), "Tests getPhrase");
    }

}
