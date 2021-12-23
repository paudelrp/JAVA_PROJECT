import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Player class
 *
 * @author Erik Ciliano
 */
public class PlayerTest {
    /** Player object used for testing */
    private Player testPlayer;

    /**
     * Sets up test object before each test
     */
    @BeforeEach
    public void setUp() {
        testPlayer = new Player("Erik", 0);
    }

    /**
     * Tests the getName method
     */
    @Test
    public void testGetName() {
        assertEquals("Erik", testPlayer.getName(), "Tests getName()");
    }

    /**
     * Tests the getRoundScore method
     */
    @Test
    public void testGetRoundScore() {
        assertEquals(0, testPlayer.getRoundScore(), "Tests getRoundScore()");
    }

    /**
     * Tests the getGameScore method
     */
    @Test
    public void testGetGameScore() {
        assertEquals(0, testPlayer.getGameScore(), "Tests getGameScore()");
    }

    /**
     * Tests the setName method
     */
    @Test
    public void testSetName() {
        String newName = "Alex";
        testPlayer.setName(newName);
        assertEquals(newName, testPlayer.getName(), "Tests that player has new name after setName");
    }

    /**
     * Tests the addRoundScore method
     */
    @Test
    public void testAddRoundScore() {
        int newScore = 250;
        testPlayer.addRoundScore(newScore);
        assertEquals(newScore, testPlayer.getRoundScore(), "Tests player score after method");
    }

    /**
     * Tests the addGameScore method
     */
    @Test
    public void testAddGameScore() {
        int newScore = 250;
        testPlayer.addGameScore(newScore);
        assertEquals(newScore, testPlayer.getGameScore(), "Tests player score after method");
    }

    /**
     * Tests the resetRoundScore method
     */
    @Test
    public void testResetRoundScore() {
        int tempScore = 300;
        testPlayer.addRoundScore(tempScore);
        assertEquals(tempScore, testPlayer.getRoundScore(), "Tests that temp score was set");
        testPlayer.resetRoundScore();
        assertEquals(0, testPlayer.getRoundScore(), "Tests that score was reset");
    }

    /**
     * Tests the updateGameScore method
     */
    @Test
    public void testUpdateGameScore() {
        int newScore = 400;
        testPlayer.addRoundScore(newScore);
        //test that round score is now 400
        assertEquals(newScore, testPlayer.getRoundScore(), "Tests that round score was updated");
        //test that game score is 0
        assertEquals(0, testPlayer.getGameScore(), "Tests that game score is unchanged");

        testPlayer.updateGameScore();
        //test that round score was reset
        assertEquals(0, testPlayer.getRoundScore(), "Tests that round score was reset");
        //test that game score was updated
        assertEquals(newScore, testPlayer.getGameScore(), "Tests that game score was updated");
    }

    /**
     * Tests the getActions method
     */
    @Test
    public void testGetActions() {
        assertEquals(0, testPlayer.getActions(), "Tests that inital number of actions is 0");
    }

    /**
     * Tests the incActions method using getActions after 0, 1, and 3 total calls to incActions
     */
    @Test
    public void testIncActions() {
        assertEquals(0, testPlayer.getActions(), "Tests that inital number of actions is 0");
        testPlayer.incActions();
        assertEquals(1, testPlayer.getActions(), "Tests that number of actions has incremented");
        testPlayer.incActions();
        testPlayer.incActions();
        assertEquals(3, testPlayer.getActions(), "Tests that number of actions has incremented");
    }

}
