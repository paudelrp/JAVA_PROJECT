/**
 * Creates puzzles with two fields: category and phrase
 *
 * @author Alex Sawdy
 */
public class Puzzle {

    /** category of the puzzle */
    private String category;

    /** phrase of the puzzle */
    private String phrase;

    /**
    * Constructor for puzzle
    *
    * @param c String of category
    * @param p String of phrase
    */
    public Puzzle(String c, String p) {
        this.category = c;
        this.phrase = p;
    }

    /**
    * Get category of puzzle
    *
    * @return String category of puzzle
    */
    public String getCategory() {
        return this.category;
    }

    /**
    * Get phrase of puzzle
    *
    * @return String phrase of puzzle
    */
    public String getPhrase() {
        return this.phrase;
    }
}
