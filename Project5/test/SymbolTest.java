import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Symbol class
 *
 * @author Suzanne Balik
 * @author Rabin Paudel
 */

public class SymbolTest {

    /** Mr. Wuf symbol */
    private Symbol wuf;

    /**
    * Mr. Rabin symbol
    */

    private Symbol rabin;

    /**
     * Creates fields before each test case is executed
     */

    @BeforeEach
    public void setUp() {
        wuf = new Symbol("Mr. Wuf", 100);
        rabin = new Symbol("Mr. Rabin", 100);
    }

    /**
     * Test getName for Mr. Wuf
     */
    @Test
    public void testGetNameWuf() {
        assertEquals("Mr. Wuf", wuf.getName(), "Test getName for Mr. Wuf");
    }

    /**
     * Test getName for Mr. Rabin
     */

    @Test
    public void testGetNameRabin() {
        assertEquals("Mr. Rabin", rabin.getName(), "Test getName for Mr. Rabin");
    }

    /**
     * Test getValue for Mr. Wuf
     */

    @Test
    public void testGetValueWuf() {
        assertEquals(100, wuf.getValue(), "Test getValue for Mr. Wuf");
    }

    /**
     * Test getValue for Mr. Rabin
     */

    @Test
    public void testGetValueRabin() {
        assertEquals(100, rabin.getValue(), "Test getValue for Mr. Rabin");
    }

    /**
     * Test toString for Mr. Wuf
     */

    @Test
    public void testToStringWuf() {
        assertEquals("Mr. Wuf 100", wuf.toString(), "Test toString for Mr. Wuf" );
    }

    /**
     * Test toString for Mr. Rabin
     */

    @Test
    public void testToStringRabin() {
        assertEquals("Mr. Rabin 100", rabin.toString(), "Test toString for Mr. Rabin " );
    }

    /**
     * Test equals for Mr. Wuf
     */

    @Test
    public void testEqualsWuf() {
        assertTrue(wuf.equals(wuf), "wuf equals with same instance");
        assertTrue(wuf.equals(new Symbol("Mr. Wuf", 100)), "wuf equals with different instances");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 100)), "wuf with different name");
        assertFalse(wuf.equals(new Symbol("Mr. Wuf", 101)), "wuf with different value");
        assertFalse(wuf.equals(new Symbol("Mr. wuf", 101)), "wuf with different name and value");
        assertFalse(wuf.equals(null), "wuf compared to null object");
        assertFalse(wuf.equals("Mr. Wuf"), "wuf compared to String");
    }

    /**
     * Test equals for Mr. Rabin
     */

    @Test
    public void testEqualsRabin() {
        assertTrue(rabin.equals(rabin), "rabin equals with same instance");
        assertTrue(rabin.equals(new Symbol("Mr. Rabin", 100)),
            "rabin equals with different instances");
        assertFalse(rabin.equals(new Symbol("Mr. Rabin", 101)), "rabin with different name");
        assertFalse(rabin.equals(new Symbol("Mr. Rabin", 103)), "rabin with different value");
        assertFalse(rabin.equals(new Symbol("Mr. Rabin", 103)),
            "rabin with different name and value");
        assertFalse(rabin.equals(null), "Rabin compared to null object");
        assertFalse(rabin.equals("Mr. Rabin"), "rabin compared to String");
    }
}
