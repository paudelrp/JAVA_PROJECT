/**
* Symbol Reel
*
* @author Rabin Paudel
*/

public class Reel {

    /**
    * constant final int NUMBER_OF_SYMBOLS
    */

    public static final int NUMBER_OF_SYMBOLS = 5;

    /**
    * constant final String SYMBOL_NAMES
    */

    public static final String[] SYMBOL_NAMES = { "State Symbols", "Hearts", "Bars", "Cherries",
        "Sevens" };

    /**
    * constant final int  SYMBOL_VALUES
    */

    public static final int[] SYMBOL_VALUES = { 10, 25, 50, 75, 100 };

    /**
    * constant final int  SYM_FOUR
    */

    public static final int SYM_FOUR = 4;

    /**
    * constant final int  SYM_THREE
    */

    public static final int SYM_THREE = 3;

    /**
    * private method symbols
    */

    private Symbol[] symbols;

    /**
    * private method currentIndex
    */

    private int currentIndex;

    /**
    * private method direction
    */

    private int direction;

    /**
    * The constructor of reel class, we must create an array of five symbol objects.
    * the instance variavle that knowns the value of the current index will be set to zero
    * the instance variable that knows the direction the real is turning to the direction that
    * passed into the constructor
    * @param direction int values
    * @throws IllegalArgumentException "Illegal direction"
    */

    public Reel(int direction) {
        symbols = new Symbol[NUMBER_OF_SYMBOLS];
        symbols[0] = new Symbol(SYMBOL_NAMES[0], SYMBOL_VALUES[0]);
        symbols[1] = new Symbol(SYMBOL_NAMES[1], SYMBOL_VALUES[1]);
        symbols[2] = new Symbol(SYMBOL_NAMES[2], SYMBOL_VALUES[2]);
        symbols[SYM_THREE] = new Symbol(SYMBOL_NAMES[SYM_THREE], SYMBOL_VALUES[SYM_THREE]);
        symbols[SYM_FOUR] = new Symbol(SYMBOL_NAMES[SYM_FOUR], SYMBOL_VALUES[SYM_FOUR]);
        currentIndex = 0;
        if (direction == -1 || direction == 1) {
            this.direction = direction;
        } else {
            throw new IllegalArgumentException("Illegal direction");
        }
    }

    /**
    * This method simply return the symbol at the current index in the symbol array.
    * @return the symbols
    */

    public Symbol getCurrentSymbol() {
        return symbols[currentIndex];
    }

    /**
    * this method simply return current index.
    * @return the currentIndex
    */

    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
    * this method "turns" the real by changing the value of the instance variable
    * if the reel is turning upward from index 0, the current index should be set to 4.
    * if the reel is turning downward from index 4 the current index should be set to 0.
    */

    public void turn() {
        if (direction == -1) {
            if (getCurrentIndex() == 0) {
                currentIndex = SYM_FOUR;
            } else if (getCurrentIndex() > 0 && getCurrentIndex() <= SYM_FOUR) {
                currentIndex = currentIndex + direction;
            }
        } else if (direction == 1) {
            if (getCurrentIndex() == SYM_FOUR) {
                currentIndex = 0;
            } else if (getCurrentIndex() >= 0 && getCurrentIndex() < SYM_FOUR) {
                currentIndex = currentIndex + direction;
            }
        }
    }

    /**
    * this method returns a String representation of the reel.
    * @return str values
    */
    public String toString() {
        String str = "";
        str += "Current index: " + getCurrentIndex() + "\n";
        str += "Current symbol: " + SYMBOL_NAMES[getCurrentIndex()] + "\n";
        for (int i = 0; i < symbols.length; i++) {
            str += "Symbol " + i + ": " +  symbols[i].toString() + "\n";
        }
        return str;
    }
}
