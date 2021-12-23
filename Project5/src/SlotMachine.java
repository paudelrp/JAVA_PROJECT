import java.util.Random;

/**
* Symbol SlotMachine
*
* @author Rabin Paudel
*/

public class SlotMachine {

    /**
    * constant final int BET_AMOUNT
    */

    public static final int BET_AMOUNT = 5;

    /**
    * constant final int VAL_THREE
    */
    public static final int VAL_THREE = 3;

    /**
    * constant final int VAL_FIFTY
    */
    public static final int VAL_FIFTY = 50;

    /**
    * private reels
    */

    private Reel[] reels;

    /**
    * private numberOfTokens
    */

    private int numberOfTokens;

    /**
    * private status
    */

    private String status;

    /**
    * private random rand
    */

    private Random rand;

    /**
    * this is the constructor of the class
    * the instance variable that knows the number of tokens held by the player should set fifty.
    * the reels at index zero and two in the array must be created to spin downward
    * if the seed is less than zero the random number generator should be created without seed.
    * if the seed is less than zero, the random number generator should be seeded with the given
    * value.
    * @param seed int values.
    */

    public SlotMachine (int seed) {
        numberOfTokens = VAL_FIFTY;
        reels = new Reel[VAL_THREE];
        reels[0] = new Reel(1);
        reels[1] = new Reel(-1);
        reels[2] = new Reel(1);
        status = "Pull Lever To Begin";
        if (seed < 0) {
            rand = new Random();
        }
        if (seed >= 0) {
            rand = new Random(seed);
        }
    }

    /**
    * This method simulates inserting BET_AMOUNT "tokens" into the machine to play game.
    * @throws IllegalStateException "Not enough tokens for bet"
    */

    public void makeBet() {
        if (getNumberOfTokens() >= BET_AMOUNT) {
            numberOfTokens = numberOfTokens - BET_AMOUNT;
        }
        else {
            throw new IllegalStateException("Not enough tokens for bet");
        }
    }

    /**
    * this method simply returns the value of the instance variable
    * @return numberOfTokens
    */

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    /**
    * this method simply returns the value of instance variable.
    * @return status
    */

    public String getStatus() {
        return status;
    }

    /**
    * this method returns the current index of the reel in array of reel objects
    * at the index specified by the parameter index.
    * @param index int value
    * @return reels[index].getCurrentIndex
    */

    public int getCurrentIndexOfReel(int index) {
        return reels[index].getCurrentIndex();
    }

    /**
    * we generate random number between zero and two.
    * call turn() method on reel at the index specified by parameter
    */

    public void turnReel() {
        int randomInt = rand.nextInt(3);
        reels[randomInt].turn();
    }

    /**
    * this method is called when the reals have finished spinning
    * this method must use the equals() methods of the symbol class tom determine if
    * the current symbols being on each wheel are the same
    * this method must be determine if there is a winning set
    */

    public void determineOutcome() {
        int currentWinning = 0;
        if (reels[0].getCurrentSymbol().equals(reels[1].getCurrentSymbol()) &&
            reels[0].getCurrentSymbol().equals(reels[2].getCurrentSymbol())) {
            currentWinning = BET_AMOUNT * reels[0].getCurrentSymbol().getValue();
            numberOfTokens += currentWinning;
            status = VAL_THREE + " " + reels[0].getCurrentSymbol().getName() + "!" +
                currentWinning + " Tokens!";
        }
        else if (reels[0].getCurrentSymbol().equals(reels[1].getCurrentSymbol())){
            currentWinning = 2 * reels[0].getCurrentSymbol().getValue();
            numberOfTokens += currentWinning;
            status = 2 + " " + reels[0].getCurrentSymbol().getName() + "!" +
                currentWinning + " Tokens!";
        }
        else if (reels[0].getCurrentSymbol().equals(reels[2].getCurrentSymbol())) {
            currentWinning = 2 * reels[0].getCurrentSymbol().getValue();
            numberOfTokens += currentWinning;
            status = 2 + " " + reels[0].getCurrentSymbol().getName() + "! " +
                currentWinning + " Tokens!";
        }
        else if (reels[1].getCurrentSymbol().equals(reels[2].getCurrentSymbol())){
            currentWinning = 2 * reels[1].getCurrentSymbol().getValue();
            numberOfTokens += currentWinning;
            status = 2 + " " + reels[1].getCurrentSymbol().getName() + "!" +
                currentWinning + " Tokens!";
        }
        else {
            status = "You Lose";
        }
    }
}
