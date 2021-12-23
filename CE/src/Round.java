/**
 * Creates a round with a round number and puzzle to be used.
 *
 * @author Alex Sawdy
 */
public class Round {

    /** number of letters in alphabet */
    public static final int ALPHABET = 26;

    /** Puzzle object used for the round */
    private Puzzle puzzle;

    /** round number */
    private int round;

    /** array of blank characters to display in game for the puzzle */
    private char[] blanks;

    /** array of all guessed characters, in order of usage */
    private char[] letters;

    /**
    * Round constructor
    *
    * @param round integer of the round number
    * @param puzzle the Puzzle object used in the round
    */
    public Round(int round, Puzzle puzzle) {
        this.round = round;
        this.puzzle = puzzle;
        // letters array set to length of alphabet
        this.letters = new char[ALPHABET];
        for (int i = 0; i < this.letters.length; ++i) {
            this.letters[i] = ' ';
        }

        // fills an array, with underscores in place of letters
        String phrase = this.puzzle.getPhrase();
        this.blanks = new char[phrase.length()];
        for (int i = 0; i < phrase.length(); ++i) {
            if (Character.isLetter(phrase.charAt(i))) {
                this.blanks[i] = '_';
            } else {
                this.blanks[i] = phrase.charAt(i);
            }
        }
    }

    /**
    * Get round number of Round
    *
    * @return int round number
    */
    public int getRound() {
        return this.round;
    }

    /**
    * Get puzzle object of Round
    *
    * @return Puzzle puzzle of round
    */
    public Puzzle getPuzzle() {
        return this.puzzle;
    }

    /**
    * Get char[] array of blanks to display puzzle phrase
    *
    * @return char[] blanks character array
    */
    public char[] getBlanks() {
        return this.blanks;
    }

    /**
    * Set round number of puzzle
    *
    * @param newRound int of the round
    */
    public void setRound(int newRound) {
        this.round = newRound;
    }

    /**
    * Update array of used letters with next letter used
    *
    * @param c character to add to used letters array
    */
    public void updateLetters(char c) {
        for (int i = 0; i < this.letters.length; ++i) {
            if (this.letters[i] == ' ') {
                this.letters[i] = c;
                // immediately exit loop after adding character to first available spot
                break;
            }
        }
    }

    /**
    * Get letters array
    *
    * @return char[] character array of all used letters
    */
    public char[] getLetters() {
        return this.letters;
    }

    /**
    * Return true if letter has been used this round, false otherwise
    *
    * @param c character to check if used
    * @return boolean whether the letter has already been used
    */
    public boolean ifLetterUsed(char c) {
        for (int i = 0; i < this.letters.length; ++i) {
            if (this.letters[i] == c) {
                return true;
            }
        }
        return false;
    }

    /**
    * Update blank character array by adding the letter where it appears in phrase
    *
    * @param character char to add to blanks array
    * @return int how many times the character is used
    */
    public int inputCharBlanks(char character) {
        int charCount = 0;
        String phrase = this.puzzle.getPhrase();
        char[] phraseArray = new char[phrase.length()];
        for (int i = 0; i < phrase.length(); ++i) {
            phraseArray[i] = phrase.charAt(i);
        }
        for (int i = 0; i < phrase.length(); ++i) {
            if (phraseArray[i] == character) {
                this.blanks[i] = character;
                charCount++;
            }
        }
        return charCount;
    }

    /**
     * Fills out the blanks array with the completed puzzle phrase
     */
    public void solveBlanks() {
        String phrase = this.puzzle.getPhrase();
        for (int i = 0; i < phrase.length(); ++i) {
            if (Character.isLetter(phrase.charAt(i))) {
                this.blanks[i] = phrase.charAt(i);
            }
        }
    }

    /**
     * Checks if the blanks array contains the solved puzzle.
     *
     * @return true or false based on wheter or not the array contains the solved puzzle
     */
    public boolean isSolved() {
        // i think there is also an equals method for arrays but this works currently so
        String phrase = this.puzzle.getPhrase();
        char[] phraseArray = new char[phrase.length()];
        for (int i = 0; i < this.blanks.length; ++i) {
            phraseArray[i] = phrase.charAt(i);
        }
        for (int i = 0; i < this.blanks.length; ++i) {
            if (phraseArray[i] != this.blanks[i]) {
                return false;
            }
        }
        return true;
    }
}
