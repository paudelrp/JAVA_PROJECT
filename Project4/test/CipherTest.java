import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Program to test Cipher methods
 *
 * @author Suzanne Balik
 * @author Rabin Paudel
 */
public class CipherTest {

    /** Alphabet */
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /** Alphabet reversed */
    public static final String ALPHABET_REVERSED = "zyxwvutsrqponmlkjihgfedcba";

    /** Rabin */
    public static final String RABIN = "RabinPaudel";

    /** Rabin reversed */
    public static final String RABIN_REVERSED = "leduaPnibaR";

    /** SASCODE */
    public static final String SASCODE = "%MACROand%MEND";

    /** SASCODE reversed */
    public static final String SASCODE_REVERSED = "DNEM%dnaORCAM%";

    /** One uppercase word */
    public static final String UPPERCASE_WORD = "COMPUTER";

    /** One uppercase word shifted forward 2 with no wraparound */
    public static final String UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND = "EQORWVGT";

        /** One uppercase worda */
    public static final String UPPERCASE_WORDA = "RABIN";

    /** Upper case word shift forwarda three word upward*/
    public static final String UPPERCASE_WORD_SHIFT_FORWARDA = "UDELQ";

    /** One uppercase worda */
    public static final String UPPERCASE_WORDB = "PAUDEL";

    /** Upper case word shift two word upward*/
    public static final String UPPERCASE_WORD_SHIFT_FORWARDB = "RCWFGN";

    /** lower word */
    public static final String LOWER_WORD = "efghij";

    /** Lower word shigt forward four wordupward*/
    public static final String LOWER_WORD_SHIFT_FORWARD = "ijklmn";

    /** lower word */
    public static final String LOWER_WORDA = "over";

    /** Lower word shigt forward two wordupward*/
    public static final String LOWER_WORD_SHIFT_FORWARDA = "qxgt";

    /** lower word */
    public static final String LOWER_WORDB = "wxyz";

    /** Lower word shigt forward two wordupward*/
    public static final String LOWER_WORD_SHIFT_FORWARDB = "yzab";

    /**
     * Test reversing null string
     */
    @Test
    public void testReverseLine0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.reverseLine(null),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test reversing entire alphabet
     */

    @Test
    public void testReverseLine1() {
        String description = "Reverse Line 1: alphabet";
        String actual = Cipher.reverseLine(RABIN);
        assertEquals(RABIN_REVERSED, actual, description);
    }

    /**
     * Test reversing entire alphabet
     */

    @Test
    public void testReverseLine2() {
        String description = "Reverse Line 1: alphabet";
        String actual = Cipher.reverseLine(SASCODE);
        assertEquals(SASCODE_REVERSED, actual, description);
    }

    /**
     * Test shifting null string forward
     */

    @Test
    public void testShiftLineLettersForward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test shifting string forward with invalid shift amount
     */

    @Test
    public void testShiftLineLettersForward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersForward(ALPHABET, -1),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */
    @Test
    public void testShiftLineLettersForward2() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(UPPERCASE_WORD, 2);
        assertEquals(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, actual, description);
    }

    /**
     * Test one shifting one word forward 3 with no wraparound
     */

    @Test
    public void testShiftLineLettersForward3() {
        String description = "Shift uppercase word forward 3 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(UPPERCASE_WORDA, 3);
        assertEquals(UPPERCASE_WORD_SHIFT_FORWARDA, actual, description);
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersForward4() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(UPPERCASE_WORDB, 2);
        assertEquals(UPPERCASE_WORD_SHIFT_FORWARDB, actual, description);
    }

    /**
     * Test one shifting one word forward 4 with no wraparound
     */

    @Test
    public void testShiftLineLettersForward5() {
        String description = "Shift uppercase word forward 4 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(LOWER_WORD, 4);
        assertEquals(LOWER_WORD_SHIFT_FORWARD, actual, description);
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersForward6() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(LOWER_WORDA, 2);
        assertEquals(LOWER_WORD_SHIFT_FORWARDA, actual, description);
    }

    /**
     * Test one shifting one word forward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersForward7() {
        String description = "Shift uppercase word forward 2 with no wraparound";
        String actual = Cipher.shiftLineLettersForward(LOWER_WORDB, 2);
        assertEquals(LOWER_WORD_SHIFT_FORWARDB, actual, description);
    }

    /**
     * Test shifting null string backward
     */

    @Test
    public void testShiftLineLettersBackward0() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(null, 1),
                "line is null");
        assertEquals("Invalid line", exception.getMessage(),
                "line is null - exception message");
    }

    /**
     * Test shifting string backward with invalid shift amount
     */

    @Test
    public void testShiftLineLettersBackward1() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> Cipher.shiftLineLettersBackward(ALPHABET, 26),
                "shift amount is negative");
        assertEquals("Invalid amount", exception.getMessage(),
                "shift amount is negative - exception message");
    }

    /**
     * Test one shifting one word backward
     */

    @Test
    public void testShiftLineLettersBackward2() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual =
            Cipher.shiftLineLettersBackward(UPPERCASE_WORD_SHIFT_FORWARD_NO_WRAPAROUND, 2);
        assertEquals(UPPERCASE_WORD, actual, description);
    }

    /**
     * Test one shifting one word backward 3 with no wraparound
     */

    @Test
    public void testShiftLineLettersBackward3() {
        String description = "Upper case word shift forwarda";
        String actual =
            Cipher.shiftLineLettersBackward(UPPERCASE_WORD_SHIFT_FORWARDA, 3);
        assertEquals(UPPERCASE_WORDA, actual, description);
    }

    /**
     * Test one shifting one word backward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersBackward4() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual =
            Cipher.shiftLineLettersBackward(UPPERCASE_WORD_SHIFT_FORWARDB, 2);
        assertEquals(UPPERCASE_WORDB, actual, description);
    }

    /**
     * Test one shifting one word backward 4 with no wraparound
     */

    @Test
    public void testShiftLineLettersBackward5() {
        String description = "Shift uppercase word backward 4 with no wraparound";
        String actual =
            Cipher.shiftLineLettersBackward(LOWER_WORD_SHIFT_FORWARD, 4);
        assertEquals(LOWER_WORD, actual, description);
    }

    /**
     * Test one shifting one word backward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersBackward6() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual =
            Cipher.shiftLineLettersBackward(LOWER_WORD_SHIFT_FORWARDA, 2);
        assertEquals(LOWER_WORDA, actual, description);
    }

    /**
     * Test one shifting one word backward 2 with no wraparound
     */

    @Test
    public void testShiftLineLettersBackward7() {
        String description = "Shift uppercase word backward 2 with no wraparound";
        String actual =
            Cipher.shiftLineLettersBackward(LOWER_WORD_SHIFT_FORWARDB, 2);
        assertEquals(LOWER_WORDB, actual, description);
    }


}
