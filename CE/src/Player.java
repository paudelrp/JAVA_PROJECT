/**
 * Class representing Player. Players have names and scores.
 *
 * @author Alex Sawdy
 * @author Lily Bai
 */
public class Player {

    /** Name of the player */
    private String name;

    /** Score the player gets in a round */
    private int roundScore;

    /** player's total game score */
    private int gameScore;

    /** player's total actions */
    private int actionCounter;

    /**
    * Constructor for player
    *
    * @param name String of player name
    * @param score int of players score
    */
    public Player(String name, int score) {
        this.name = name;
        this.roundScore = score;
        this.gameScore = 0;
        this.actionCounter = 0;
    }

    /**
    * Default constructor for player
    */
    public Player() {
        this.name = null;
        this.roundScore = 0;
        this.gameScore = 0;
        this.actionCounter = 0;
    }

    /**
     * Get name of player
     *
     * @return String of name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get (round) score of player
     *
     * @return int of round score
     */
    public int getRoundScore() {
        return this.roundScore;
    }

    /**
     * Get game score of player
     *
     * @return int of game score
     */
    public int getGameScore() {
        return this.gameScore;
    }


    /**
     * Set (round) score of player
     *
     * @param newName string of a new name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Adds value to player's round score
     *
     * @param newScore int of a new score
     */
    public void addRoundScore(int newScore) {
        this.roundScore = this.roundScore + newScore;
    }

    /**
     * Adds value to game score of player
     *
     * @param newScore int of a new score
     */
    public void addGameScore(int newScore) {
        this.gameScore = this.gameScore + newScore;
    }

    /**
     * Sets game score of player to their round score, then resets that player's round score
     */
    public void updateGameScore() {
        this.gameScore = this.roundScore;
        resetRoundScore();
    }

    /**
     * Resets the player's round score
     */
    public void resetRoundScore() {
        this.roundScore = 0;
    }

    /**
     * Get action count of player
     *
     * @return int of player's actions taken
     */
    public int getActions() {
        return this.actionCounter;
    }


    /**
     * Increment the players action counter by one
     */
    public void incActions() {
        this.actionCounter = this.actionCounter + 1;
    }
}
