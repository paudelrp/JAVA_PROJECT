import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Reel class
 * @author Suzanne Balik
 * @author Rabin Paudel
 */

public class ReelTest {

    /**
    * test reel
    */

    private Reel reel;

    /**
    * testsetup
    */

    @BeforeEach
    public void setUp() {
        reel = new Reel(-1);
    }

    /**
    * testConstant
    */

    @Test
    public void testConstants() {
        assertEquals(5, Reel.NUMBER_OF_SYMBOLS, "NUMBER_OF_SYMBOLS");
        assertEquals("State Symbols", Reel.SYMBOL_NAMES[0], "SYMBOL_NAMES[0]");
        assertEquals("Hearts", Reel.SYMBOL_NAMES[1], "SYMBOL_NAMES[1]");
        assertEquals("Bars", Reel.SYMBOL_NAMES[2], "SYMBOL_NAMES[2]");
        assertEquals("Cherries", Reel.SYMBOL_NAMES[3], "SYMBOL_NAMES[3]");
        assertEquals("Sevens", Reel.SYMBOL_NAMES[4], "SYMBOL_NAMES[4]");

        assertEquals(10, Reel.SYMBOL_VALUES[0], "SYMBOL_VALUES[0]");
        assertEquals(25, Reel.SYMBOL_VALUES[1], "SYMBOL_VALUES[1]");
        assertEquals(50, Reel.SYMBOL_VALUES[2], "SYMBOL_VALUES[2]");
        assertEquals(75, Reel.SYMBOL_VALUES[3], "SYMBOL_VALUES[3]");
        assertEquals(100, Reel.SYMBOL_VALUES[4], "SYMBOL_VALUES[4]");
    }
    /**
    * testConstructorPreConditions
    */

    @Test
    public void testConstructorPreConditions() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Reel(0),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(),
                     "Illegal direction - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(2),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(),
                     "Illegal direction - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(-2),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(),
                     "Illegal direction - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(1000),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(),
                     "Illegal direction - exception message");

        exception = assertThrows(IllegalArgumentException.class, () -> new Reel(-1000),
                "Illegal direction");
        assertEquals("Illegal direction", exception.getMessage(),
                     "Illegal direction - exception message");

    }

    /**
    * testGetCurrentIndex
    */

    @Test
    public void testGetCurrentIndex() {
        assertEquals(0, reel.getCurrentIndex(), "Current index after constructed");
    }

    /**
    * testGetCurrentSymbol
    */

    @Test
    public void testGetCurrentSymbol() {
        assertEquals(new Symbol("State Symbols", 10), reel.getCurrentSymbol(),
                     "Current symbol after constructed");
    }

    /**
    * testToString
    */

    @Test
    public void testToString() {
        assertEquals("Current index: 0\n" + "Current symbol: State Symbols\n" +
                     "Symbol 0: State Symbols 10\n" + "Symbol 1: Hearts 25\n" +
                     "Symbol 2: Bars 50\n" + "Symbol 3: Cherries 75\n" +
                     "Symbol 4: Sevens 100\n",
                     reel.toString(), "toString  after constructed");
    }

    /**
    * testTurn
    */

    @Test
    public void testTurn() {
        reel = new Reel(-1);
        reel.turn();
        assertEquals(4, reel.getCurrentIndex(), "Index 0");
        reel.turn();
        assertEquals(3, reel.getCurrentIndex(), "Index 3");
        reel.turn();
        assertEquals(2, reel.getCurrentIndex(), "Index 2");
        reel.turn();
        assertEquals(1, reel.getCurrentIndex(), "Index 1");
        reel.turn();
        assertEquals(0, reel.getCurrentIndex(), "Index 1");
        reel.turn();
        assertEquals(4, reel.getCurrentIndex(), "Index 1");

        reel = new Reel(1);
        reel.turn();
        assertEquals(1, reel.getCurrentIndex(), "Index 1");
        reel.turn();
        assertEquals(2, reel.getCurrentIndex(), "Index 2");
        reel.turn();
        assertEquals(3, reel.getCurrentIndex(), "Index 4");
        reel.turn();
        assertEquals(4, reel.getCurrentIndex(), "Index 4");
        reel.turn();
        assertEquals(0, reel.getCurrentIndex(), "Index 0");
        reel.turn();
        assertEquals(1, reel.getCurrentIndex(), "Index 1");
    }
}
