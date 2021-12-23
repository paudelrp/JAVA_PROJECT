/**
 * Allows updating of the round number. Kind of strange? better fix likely?
 *
 * @author Alex Sawdy
 */
public class RoundCounter {

    /** round number */
    private int roundNum = 0;

    /**
     * Get current round number
     *
     * @return int round number counter
     */
    public int getRoundNum() {
        return this.roundNum;
    }

    /**
     * Increase round number counter by 1
     */
    public void incRound() {
        roundNum++;
    }
}
