import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Game class, which runs the Wheel of Fortune Program
 *
 * @author Erik Ciliano
 * @author Alex Sawdy
 */
public class GameTest {

    /** Puzzle object used for testing */
    private Puzzle puzzle1 = new Puzzle("RESTAURANTS", "WAFFLE HOUSE");

    /** Puzzle object used for testing */
    private Puzzle puzzle2 = new Puzzle("FRUITS", "APPLES");

    /** Puzzle object used for testing */
    private Puzzle puzzle3 = new Puzzle("PHRASES", "PIECE OF CAKE");

    /** Array of Puzzle objects used for testing */
    private Puzzle[] puzzleArray = {puzzle1, puzzle2, puzzle3};

    /** What the update Puzzle object array should look like after testing */
    private Puzzle[] newPuzzleArray = {puzzle2, puzzle3};

    /** RoundCounter object used for testing */
    private RoundCounter testRoundCounter = new RoundCounter();

    /** Seeded random object used for testing */
    private Random testRand = new Random(0);

    /** Round object used for testing */
    private Round testRound = new Round(1, puzzle1);

    /**
     * Tests createRound. The returned round should be the same as the round created in
     * the fields due to the seeded random.
     */
    @Test
    public void testCreateRound() {
        Round createdRound = Game.createRound(testRand, puzzleArray, testRoundCounter);
        assertEquals(testRound.getRound(), createdRound.getRound());
        assertEquals(testRound.getPuzzle().getCategory(), createdRound.getPuzzle().getCategory());
        assertEquals(testRound.getPuzzle().getPhrase(), createdRound.getPuzzle().getPhrase());
    }

    /**
     * Tests the createRandom method
     */
    @Test
    public void testCreateRandom() {
        Random actualRand1 = Game.createRandom(0);
        assertEquals(testRand.nextInt(), actualRand1.nextInt(), "Tests if Random is seeded same");
        Random actualRand2 = Game.createRandom(1);
        assertNotEquals(testRand.nextInt(), actualRand2.nextInt(), "Random seeded differently");
    }

    /**
     * Tests the createPuzzles method
     */
    @Test
    public void testCreatePuzzles() {
        String strTest = "test-files/test.txt";
        Scanner puzzleCount = null;
        try {
            puzzleCount = new Scanner(new FileInputStream(strTest));
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to access input file: " + strTest);
        }
        assertNotNull(puzzleCount, "Check that Scanner is not null");
        Puzzle[] testPuzzlesArray = Game.createPuzzles(strTest, puzzleCount);
        assertNotNull(testPuzzlesArray, "Check that Scanner is not null");
        assertEquals(puzzleArray[0].getCategory(), testPuzzlesArray[0].getCategory(), "puzzle 1 c");
        assertEquals(puzzleArray[1].getCategory(), testPuzzlesArray[1].getCategory(), "puzzle 2 c");
        assertEquals(puzzleArray[2].getCategory(), testPuzzlesArray[2].getCategory(), "puzzle 3 c");
        assertEquals(puzzleArray[0].getPhrase(), testPuzzlesArray[0].getPhrase(), "puzzle 1 p");
        assertEquals(puzzleArray[1].getPhrase(), testPuzzlesArray[1].getPhrase(), "puzzle 2 p");
        assertEquals(puzzleArray[2].getPhrase(), testPuzzlesArray[2].getPhrase(), "puzzle 3 p");
    }

    /**
     * Tests the updatePuzzleArray method
     */
    @Test
    public void testUpdatePuzzleArray() {
        Puzzle[] testUpdatedArray = Game.updatePuzzleArray(puzzleArray, "RESTAURANTS");
        assertArrayEquals(newPuzzleArray, testUpdatedArray, "Tests if category was removed");
    }


    /**
     * Tests the createInput method
     */
    @Test
    public void testCreateInput() {
        String message = "valid filename";
        String expectedContents = "RESTAURANTS:WAFFLE HOUSEFRUITS:APPLESPHRASES:PIECE OF CAKE";
        Scanner actual = Game.createInput("test-files/test.txt");
        assertNotNull(actual, "Check that Scanner is not null");
        String actualContents = actual.nextLine();
        actualContents = actualContents.concat(actual.nextLine());
        actualContents = actualContents.concat(actual.nextLine());
        assertEquals(expectedContents, actualContents, message);
        actual.close();
    }
}
