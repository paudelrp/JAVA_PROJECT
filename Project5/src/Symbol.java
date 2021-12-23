/**
* Symbol class
*
* @author Rabin Paudel
*/

public class Symbol {

    /**
    * String name private class
    */

    private String name;

    /**
    * int value private class
    */

    private int value;

    /**
    * This is the constructor of the class.
    * @param name String public method.
    * @param value int public method.
    */

    public Symbol (String name, int value) {
        this.name = name;
        this.value = value;

    }

    /**
    * This method simply return in the instance field.
    * @return name.
    */

    public String getName() {
        return name;

    }

    /**
    * This method simply return in the instance field.
    * @return value
    */

    public int getValue(){
        return value;
    }

    /**
    * This method return true if and only if the Objects o.
    * @param o values
    * @return false
    */

    public boolean equals (Object o) {
        if (o instanceof Symbol) {
            Symbol obj = (Symbol)o;
            return name.equals(obj.name) && value == obj.value;
        }
        else {
            return false;
        }
    }

    /**
    * This method return a string representation of the symbol.
    * @return str
    */

    public String toString() {
        String str = name + " "  + value;
        return str;
    }
}
