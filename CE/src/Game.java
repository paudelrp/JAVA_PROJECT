import java.util.*;
import java.io.*;

/**
 * Activates the Wheel of Fortune Game in terminal
 * -> 4/23 currently just creates puzzles from a text file
 * -> 4/23 creates three players and seeds random
 * -> 4/24 creates rounds and updates puzzle array
 * -> 4/26 loops turns between three players for 1 round and allows for "Spin"
 * -> 4/26 1st round nearly fully function. spin+buy+finish work.
 * -> 4/27 plays three rounds. adds to game scores and determines who plays first
 *
 *
 * @author Alex Sawdy
 * @author Lily Bai
 */
public class Game {

    /** number of players in the game */
    public static final int PLAYER_NUM = 3;

    /** number of options on the wheel */
    public static final int WHEEL = 25;

    /** number of points required to purchase a vowel */
    public static final int VOWEL_POINTS = 250;

    /**
     * Get a file input and set up array of objects
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Wheel wheel = new Wheel();
        Scanner puzzleCount = null;
        String inputName = null;
        int seed = -1;

        // makes sure a text file was input when initialized
        if (args.length != 1 && args.length != 2) {
            System.out.println("Usage: java -cp bin Game infile (optional: seed)");
            System.exit(1);
        }
        if (args.length == 1) {
            inputName = args[0];
            puzzleCount = createInput(inputName);
        } else if  (args.length == 2) {
            inputName = args[0];
            try {
                seed = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Seed must be an integer");
                System.exit(1);
            }
            puzzleCount = createInput(inputName);
        }
        // could use createInput method here instead of in if + else if
        // initialize rand, seeded or unseeded
        Random rand = createRandom(seed);
        // creates an array of all puzzles in text file
        Puzzle[] puzzles = createPuzzles(inputName, puzzleCount);
        // creates an array of 3 user named players
        Player[] players = createPlayers(scan);
        // creates RoundCounter to keep track of how many rounds have been made
        RoundCounter roundNum = new RoundCounter();
        // creates first round w/ stored puzzle and a round number
        Round round1 = createRound(rand, puzzles, roundNum);
        // updates puzzle array to remove all puzzles with the category previously used
        puzzles = updatePuzzleArray(puzzles, round1.getPuzzle().getCategory());

        // initialize index as 0 so player 1 starts
        int playerIndex = 0;

        // while player index is not returned as a negative 1, keep cycling through turns
        while (playerIndex != -1) {
            playerIndex = playTurn(round1, players, wheel, scan, rand, playerIndex);
        }

        // displays winnings, updates scores, determines who will go first in the next round
        playerIndex = endRound(round1, players, rand, playerIndex);

        // print who will begin round 2
        System.out.println("The player beginning the next round, based on last round's score, is " +
                           players[playerIndex].getName() + "\n\n");

        // create and play through round 2
        Round round2 = createRound(rand, puzzles, roundNum);
        puzzles = updatePuzzleArray(puzzles, round2.getPuzzle().getCategory());
        while (playerIndex != -1) {
            playerIndex = playTurn(round2, players, wheel, scan, rand, playerIndex);
        }
        playerIndex = endRound(round2, players, rand, playerIndex);
        // print who will begin round 3
        System.out.println("The player beginning the next round, based on last round's score, is " +
                           players[playerIndex].getName() + "\n\n");

        // create and play through round 3 (final round)
        Round round3 = createRound(rand, puzzles, roundNum);
        puzzles = updatePuzzleArray(puzzles, round3.getPuzzle().getCategory());
        while (playerIndex != -1) {
            playerIndex = playTurn(round3, players, wheel, scan, rand, playerIndex);
        }
        playerIndex = endRound(round3, players, rand, playerIndex);

        System.out.println("" + players[0].getName() + "'s final game score: " +
                          players[0].getGameScore() + "\n" + players[1].getName() +
                          "'s final game score: " + players[1].getGameScore() + "\n" +
                          players[2].getName() + "'s final game score: " +
                          players[2].getGameScore() + "\n");

        // determine winner
        int winner = 0;
        for (int i = 0; i < players.length; ++i) {
            if (players[i].getGameScore() > players[winner].getGameScore()) {
                winner = i;
            }
        }
        if (players[0].getGameScore() == players[1].getGameScore() &&
            players[0].getGameScore() == players[2].getGameScore()) {
            System.out.println("All scores are the same. It's a tie!");
        } else {
            System.out.println("The winner is: "  + players[winner].getName() +
                               "! Congratulations!");
        }
    }

    /**
     * Prints out the characters saved to the blanks array in that round
     *
     * @param round the Round object for the round being played
     */
    public static void displayPuzzle(Round round) {
        char[] blankChars = round.getBlanks();
        for (int i = 0; i < blankChars.length; ++i) {
            System.out.print("" + blankChars[i] + " ");
        }
        System.out.println("");
    }

    /**
     * This method plays one player's turn, allowing them to "Spin" + "Buy" + "Finish"
     *
     * @param round Round obj of the round being played, with a preselected puzzle
     * @param players array of all 3 players
     * @param wheel Wheel obj simply used to store values that can be "spun" for
     * @param in terminal scanner
     * @param rand Random object used to randomize numbers
     * @param pI the current player index
     * @return int integer representing the index of the next player, or -1 if the round is over
     */
    public static int playTurn(Round round, Player[] players, Wheel wheel,
                               Scanner in, Random rand, int pI) {
        // creates an integer to be returned that is the index of the next player who takes a turn
        int nextPlayerIndex;
        if (pI == 2) {
            nextPlayerIndex = 0;
        } else {
            nextPlayerIndex = pI + 1;
        }

        // leave loop when puzzle is finished
        while (round.isSolved() == false) {
            // defining some variables, mostly for compiling, most important components in beginning
            Puzzle puzzle = round.getPuzzle();
            String userS = "";
            char userC = ' ';
            int wheelVal;

            // print blank phrase and category, ask for input
            System.out.print("Round " + round.getRound() + " Phrase: ");
            displayPuzzle(round);
            System.out.println("Category: " + puzzle.getCategory() + "\n");

            //print current scores
            System.out.println("\n" + players[0].getName() + "'s round score: " +
                               players[0].getRoundScore() + "\n" + players[1].getName() +
                               "'s round score: " + players[1].getRoundScore() + "\n" +
                               players[2].getName() + "'s round score: " +
                               players[2].getRoundScore() + "\n");

            char[] usedLetters = round.getLetters();
            // only prints used letters if there are any in the array
            if (usedLetters[0] != ' ') {
                System.out.print("\nPreviously guessed letters, in order of usage: ");
                for (int i = 0; i < usedLetters.length; ++i) {
                    if (usedLetters[i] != ' ' && usedLetters[i + 1] != ' ') {
                        System.out.print(usedLetters[i] + ",");
                    } else if (usedLetters[i] != ' ') {
                        System.out.println(usedLetters[i]);
                    }
                }
            }

            System.out.println("\n" + players[pI].getName() + "'s turn\n\nChoose an Action:\nS - "
                               + "Spin the Wheel\nB - Buy a Vowel ($250)\nF - Finish the Puzzle");
            // prompt user for a single letter choice to decide what to do
            while (userC == ' ') {
                userS = in.nextLine();
                try {
                    userC = userS.toUpperCase().charAt(0);
                } catch (StringIndexOutOfBoundsException str) {
                    System.out.println("Please enter a single letter: (S, B, or F)");
                    continue;
                }
                if (userS.length() != 1 || (userC != 'S' && userC != 'B' && userC != 'F')) {
                    System.out.println("Please enter a single letter: (S, B, or F)");
                    userC = ' ';
                } else {
                    // increment number of actions that player has taken
                    players[pI].incActions();
                }
            }
            // divides out 'Spin' + 'Buy' + 'Finish'
            switch (userC) {
                case 'S':
                    // spin wheel, get value at random for index 0 to index 23 (24 items)
                    wheelVal = wheel.getValue(rand.nextInt(WHEEL - 1));
                    if (wheelVal == -1) {
                        System.out.println("The Wheel landed on... Bankrupt.\nToo Bad! Lose all " +
                                           "money accumulated this round.\n");
                        players[pI].resetRoundScore();
                        // new turn with next player
                        return nextPlayerIndex;
                    } else if (wheelVal == 0) {
                        System.out.println("The Wheel landed on... Lose a Turn.\nToo Bad!\n");
                        // new turn with next player
                        return nextPlayerIndex;
                    } else {
                        System.out.print("The Wheel landed on... " + wheelVal + "!\n" +
                                         "Choose a consonant: ");
                        String s;
                        char c = ' ';
                        while (c == ' ') {
                            s = in.nextLine();
                            try {
                                c = s.toUpperCase().charAt(0);
                            } catch (StringIndexOutOfBoundsException str) {
                                System.out.print("Please enter one consonant: ");
                                continue;
                            }
                            // checks if consonant, added check for single space
                            if ((c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                                c == ' ') || s.length() != 1) {
                                System.out.print("Please enter one consonant: ");
                                c = ' ';
                            // checks if letter has been used previously
                            } else if (round.ifLetterUsed(c) == true) {
                                System.out.print("Consonant already used. Try a new one: ");
                                c = ' ';
                            }
                        }
                        int charCount = round.inputCharBlanks(c);
                        // add character c to an array of used letters
                        round.updateLetters(c);
                        if (charCount > 0) {
                            int newScore = charCount * wheelVal;
                            players[pI].addRoundScore(newScore);
                            System.out.print("\nThe consonant [" + c + "] appears " + charCount +
                                             " time(s):\nYou earn " + newScore + " Points for a " +
                                             "total of: " + players[pI].getRoundScore() +
                                             " Points\n\n");
                        } else {
                            System.out.print("\nToo Bad! The consonant [" + c + "] does not appear."
                                             + " Your turn is over.\n\n");
                            return nextPlayerIndex;
                        }
                        c = ' ';
                    }
                    break;
                case 'B':
                    int currentCash = players[pI].getRoundScore();
                    // check if enough points
                    if (currentCash < VOWEL_POINTS) {
                        System.out.println("Not enough points. Try a different action.\n");
                    } else {
                        players[pI].addRoundScore(-VOWEL_POINTS);
                        System.out.print("Choose a vowel to purchase: ");
                        String s;
                        char c = ' ';
                        while (c == ' ') {
                            s = in.nextLine();
                            try {
                                c = s.toUpperCase().charAt(0);
                            } catch (StringIndexOutOfBoundsException str) {
                                System.out.print("Please enter one vowel: ");
                                continue;
                            }
                            if (!(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                                || s.length() != 1) {
                            //if ((c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U')
                            //    || s.length() != 1) {
                                // yah
                                System.out.print("Please enter one vowel: ");
                                c = ' ';
                            } else if (round.ifLetterUsed(c) == true) {
                                System.out.print("Vowel already used. Try a new one: ");
                                c = ' ';
                            }
                        }
                        int charCount = round.inputCharBlanks(c);
                        // add character c to an array of used letters
                        round.updateLetters(c);
                        if (charCount > 0) {
                            System.out.print("\nThe vowel [" + c + "] appears " + charCount +
                                             " time(s):\nYou still have a total of: "
                                             + players[pI].getRoundScore() + " Points\n\n");
                        } else {
                            System.out.print("\nToo Bad! The vowel [" + c + "] does not appear."
                                             + " Your turn is over.\n\n");
                            return nextPlayerIndex;
                        }
                        c = ' ';
                    }
                    break;
                case 'F':
                    String  ans = "";
                    String s = "";
                    char c = ' ';
                    // kind of scuffed because my brain stopped working, but it works as intended
                    while (c == ' ') {
                        System.out.print("Input completely solved phrase: ");
                        ans = in.nextLine();
                        ans = ans.toUpperCase();
                        if (ans.length() != puzzle.getPhrase().length()) {
                            System.out.println("\nYour answer and the solution have different " +
                                               "lengths. Please enter your answer again.\n" +
                                               "Spaces and apostrophes matter, but capitalization "
                                               + "does not.\n");
                            continue;
                        }
                        System.out.println("\nAre you sure you want to proceed?\nSpaces and " +
                                           "apostrophes matter, but capitalization does not.\n"
                                           + "Y - Yes\nN - No");
                        while (c == ' ') {
                            s = in.nextLine();
                            try {
                                c = s.toUpperCase().charAt(0);
                            } catch (StringIndexOutOfBoundsException str) {
                                System.out.println("Please enter one valid character: (Y/N)");
                                continue;
                            }
                            if (s.length() != 1 || (c != 'Y' && c != 'N')) {
                                System.out.println("Please enter one valid character: (Y/N)");
                                c = ' ';
                            }
                        }
                        if (s.length() == 1 && c == 'N') {
                            c = ' ';
                        }
                    }
                    if (ans.equals(puzzle.getPhrase())) {
                        System.out.print("Yes! The puzzle has been solved.\n\nThe solution is: ");
                        round.solveBlanks();
                        displayPuzzle(round);
                    } else {
                        System.out.println("Nope! Your answer does not match the solution. " +
                                           "Lose your turn.\n");
                        return nextPlayerIndex;
                    }
                    break;
                default:
                    System.out.println("\nSomething went seriously wrong with the action choices.");
                    break;
            }
        }
        return -1;
    }

    /**
     * This method displays winnings, updates scores, determines who will go first in the next round
     *
     * @param round Round obj of the round being played, with a preselected puzzle
     * @param players array of all 3 players
     * @param rand Random object used to randomize numbers
     * @param pI the current player index
     * @return int integer representing the index of the player who will start the next round
     */
    public static int endRound(Round round, Player[] players, Random rand, int pI) {

        // print final scores
        System.out.println("\n" + players[0].getName() + "'s final round score: " +
                           players[0].getRoundScore() + "\n" + players[1].getName() +
                           "'s final round score: " + players[1].getRoundScore() + "\n" +
                           players[2].getName() + "'s final round score: " +
                           players[2].getRoundScore() + "\n");

        int winnerIndex = -1;

        // grab index of the "winner"
        for (int i = 0; i < players.length - 1; ++i) {
            if (players[i].getRoundScore() > players[i + 1].getRoundScore()) {
                winnerIndex = i;
            } else if (players[i].getRoundScore() < players[i + 1].getRoundScore()) {
                winnerIndex = i + 1;
            }
        }
        // idk how else to do this, but it makes sure that the index for both "losers" are saved
        int loserIndex1 = -1;
        int loserIndex2 = -1;
        int[] indexArray = new int[]{ 0, 1, 2 };
        for (int i = 0; i < indexArray.length; ++i) {
            if (i != winnerIndex && loserIndex1 == -1) {
                loserIndex1 = i;
            } else if (i != winnerIndex) {
                loserIndex2 = i;
            }
        }

        // player with lowest score will go first
        String name1 = players[loserIndex1].getName();
        String name2 = players[loserIndex2].getName();
        int firstPlayerIndex;
        if (players[loserIndex1].getRoundScore() > players[loserIndex2].getRoundScore()) {
            firstPlayerIndex = loserIndex2;
        // if 2 lowest are the same, player's name who is first alphabetically will go first
        // capitalize these letter so that ASCII codes for lower/upper case do no matter
        } else if (players[loserIndex1].getRoundScore() == players[loserIndex2].getRoundScore()) {
            if (name1.toUpperCase().charAt(0) < name2.toUpperCase().charAt(0)) {
                firstPlayerIndex = loserIndex1;
            } else {
                firstPlayerIndex = loserIndex2;
            }
        } else {
            firstPlayerIndex = loserIndex1;
        }

        // print # of actions taken by each user
        System.out.println("" + players[0].getName() + "'s # of actions: " +
                          players[0].getActions() + "\n" + players[1].getName() +
                          "'s # of actions: " + players[1].getActions() + "\n" +
                          players[2].getName() + "'s # of actions: " +
                          players[2].getActions() + "\n");

        // if all scores are the same then winnerIndex is never changed and remains as -1
        if (winnerIndex == -1) {
            System.out.println("\nAll scores are the same. No winner.\n");
            players[0].resetRoundScore();
            players[1].resetRoundScore();
            players[2].resetRoundScore();
            System.out.println("" + players[0].getName() + "'s game score: " +
                              players[0].getGameScore() + "\n" + players[1].getName() +
                              "'s game score: " + players[1].getGameScore() + "\n" +
                              players[2].getName() + "'s game score: " +
                              players[2].getGameScore() + "\n");
            return 0;
        }

        players[winnerIndex].updateGameScore();
        players[loserIndex1].resetRoundScore();
        players[loserIndex2].resetRoundScore();
        System.out.println("\nThe winner of Round " + round.getRound() + " is " +
                           players[winnerIndex].getName() + " with " +
                           players[winnerIndex].getGameScore() + " Game Points.!\n");
        // print game scores
        System.out.println("" + players[0].getName() + "'s game score: " +
                          players[0].getGameScore() + "\n" + players[1].getName() +
                          "'s game score: " + players[1].getGameScore() + "\n" +
                          players[2].getName() + "'s game score: " +
                          players[2].getGameScore() + "\n");
        return firstPlayerIndex;
    }

    /**
     * Creates a random number
     *
     * @param seed a seed provided to random number generator
     * @return Random a Random object
     */
    public static Random createRandom(int seed) {
        Random rand = null;
        if (seed < 0) {
            rand = new Random();
        } else if (seed >= 0) {
            rand = new Random(seed);
        }
        return rand;
    }

    /**
     * Creates array of three players and names them
     *
     * @param in terminal Scanner
     * @return Player[] array of three named player with scores of 0
     */
    public static Player[] createPlayers(Scanner in) {
        Player[] players = new Player[PLAYER_NUM];
        String player1;
        String player2;
        String player3;

        // check that not blank, not equal to another player's name
        System.out.print("Enter name for Player 1: ");
        while (true) {
            player1 = in.nextLine();
            if (player1.length() == 0 || player1.charAt(0) == ' ') {
                System.out.print("Enter new name for Player 1: ");
                continue;
            }
            players[0] = new Player(player1, 0);
            break;
        }
        System.out.print("Enter name for Player 2: ");
        while (true) {
            player2 = in.nextLine();
            if (player2.equals(player1) || player2.length() == 0 || player2.charAt(0) == ' ') {
                System.out.print("Enter new name for Player 2: ");
                continue;
            }
            players[1] = new Player(player2, 0);
            break;
        }
        System.out.print("Enter name for Player 3: ");
        while (true) {
            player3 = in.nextLine();
            if (player3.equals(player2) || player3.equals(player1) || player3.length() == 0
                || player3.charAt(0) == ' ') {
                System.out.print("Enter new name for Player 3: ");
                continue;
            }
            players[2] = new Player(player3, 0);
            break;
        }

        return players;
    }

    /**
     * Creates array of three players and names them
     *
     * @param rand Random object
     * @param puzzles Puzzle array
     * @param roundNum RoundCounter object
     * @return Round round object with a stored puzzle and round number
     */
    public static Round createRound(Random rand, Puzzle[] puzzles, RoundCounter roundNum) {

        // increases the integer stored in RoundCounter by one
        roundNum.incRound();
        // puzzles.length should be sufficient for rand to be 0 through (1 - final index)
        int randIndex = rand.nextInt(puzzles.length);
        Round round = new Round(roundNum.getRoundNum(), puzzles[randIndex]);

        return round;
    }

    /**
     * This method creates an array of puzzle objects
     *
     * @param inputName name of the input file
     * @param puzzleCount Scanner with the text from the input file
     * @return Puzzle[] an array of puzzle objects
     */
    public static Puzzle[] createPuzzles(String inputName, Scanner puzzleCount) {

        // get number of lines in puzzleText
        int lineCount = 0;
        while (puzzleCount.hasNextLine()) {
            lineCount++;
            puzzleCount.nextLine();
        }
        puzzleCount.close();

        // create array of puzzle and initialize length to the number of lines in text file
        Puzzle[] puzzles = new Puzzle[lineCount];

        // create same FileInputStream as puzzleCount to use again
        Scanner puzzleText = createInput(inputName);

        // fill puzzles array with puzzles of CATEGORY:PHRASE (w/o colon)
        for (int i = 0; i < lineCount; ++i) {
            String line = puzzleText.nextLine();
            String category = line.substring(0, line.indexOf(":"));
            String phrase = line.substring(line.indexOf(":") + 1, line.length());
            puzzles[i] = new Puzzle(category, phrase);
        }
        return puzzles;
    }

    /**
     * This method updates an array of puzzle objects and removes all with specified category
     *
     * @param oldPuzzles old puzzle array
     * @param category String of the category to be removed
     * @return Puzzle[] new updated, smaller puzzle array
     */
    public static Puzzle[] updatePuzzleArray(Puzzle[] oldPuzzles, String category) {

        int count = 0;
        int oldLength = oldPuzzles.length;
        // counts number of puzzles w/o selected category
        System.out.println("oldPuzzles.length: " + oldLength);
        for (int i = 0; i < oldPuzzles.length; ++i) {
            if (!oldPuzzles[i].getCategory().equals(category)) {
                count++;
            }
        }

        Puzzle[] newPuzzles = new Puzzle[count];

        // variable to change index of oldPuzzles
        int j = 0;
        // fill new array with all puzzles w/o the old category
        for (int i = 0; i < oldPuzzles.length; ++i) {
            if (!oldPuzzles[i].getCategory().equals(category)) {
                newPuzzles[j] = oldPuzzles[i];
                j++;
            }
        }

        return newPuzzles;
    }

    /**
     * This method creates a Scanner with all the text from an inputted file
     *
     * @param filename a string representing the name of the input file
     * @return Scanner a scanner with the text from the input file
     * @throws FileNotFoundException if a file with the specified name does not exist
     */
    public static Scanner createInput(String filename) {
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("Unable to access input file: " + filename);
            System.exit(1);
        }
        return input;
    }
}
