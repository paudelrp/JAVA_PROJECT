/**
 * This class represents the wheel used in the Wheel of fortune game. The
 * wheel has 24 values it can land on. The cash values are between $500 and $1000
 * and the wheel can also land on "bankrupt" (-1) or "lose a turn" (0)
 *
 * @author Erik Ciliano
 */
public class Wheel {

    /** Array field that holds the values on the wheel */
    private int[] cashValues = {600, 950, 500, 900, 550, 1000, 850, 600, 700, 0, 800, 500, 650,
                                850, 750, 650, 0, 700, 800, 500, -1, 950, 750, 650};

    /**
     * Returns the value at a specified index of the Array
     *
     * @param index specified array index
     * @return an integer with a cash value from the wheel array
     */
    public int getValue(int index) {
        return cashValues[index];
    }

}
