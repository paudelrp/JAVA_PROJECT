import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Cipher Program
 *
 * @author Rabin Paudel
 *
 */

public class Cipher {

    /**
    * AMO_VAL
     */
    public static final int AMO_VAL = 26;

     /**
     * AMO_VALL
     */

    public static final int AMO_VALL = 25;

     /**
     * Create main method.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        String inputFile = "test-files/input.txt";
        String outputFile = "test-files/rpp.txt";
        if (args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
        } else {
            System.out.println("usage: java -cp bin Cipher infile outfile");
            System.exit(1);
        }
        Scanner sc = getInput(inputFile);
        int lin = line(sc);
        String[] inFileContains = new String[lin];
        // read and store file in array
        sc = getInput(inputFile);
        readFile(sc, inFileContains);
        // call at the end of the program
        PrintWriter pw = getOutput(outputFile);
        Scanner scanner = new Scanner(System.in);
        String cipher = "";
        char val = 'N';
        int amount = 0;
        while (val != 'Q') {
            printMenu();
            val = Character.toUpperCase(scanner.next().charAt(0));
            if (val == 'R') {
                //call process to reverse line
                for (int i = 0; i < inFileContains.length; i++) {
                    cipher = reverseLine(inFileContains[i]);
                    inFileContains[i] = cipher;
                }
            } else if (val == 'F') {
                System.out.println("Enter amount (1-25): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid amount");
                    System.exit(1);
                }
                amount = scanner.nextInt();
                if (amount < 1 || amount > AMO_VALL ) {
                    System.out.println("Invalid amount");
                }
                else {
                    for (int i = 0; i < inFileContains.length; i++) {
                        cipher = shiftLineLettersForward(inFileContains[i], amount);
                        inFileContains[i] = cipher;
                    }
                }
            }
            else if (val == 'B') {
                // backward
                System.out.println("Enter amount (1-25): ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Invalid amount");
                    System.exit(1);
                }
                amount = scanner.nextInt();
                if (amount < 1 || amount > AMO_VALL ) {
                    System.out.println("Invalid amount");
                    System.exit(1);
                } else {
                    for (int i = 0; i < inFileContains.length; i++) {
                        cipher = shiftLineLettersBackward(inFileContains[i], amount);
                        inFileContains[i] = cipher;
                    }
                }
            }
        }
        for (int i = 0; i < inFileContains.length; i++) {
            pw.print(inFileContains[i] + "\n");
        }
        pw.close();
        //System.out.println(Arrays.toString(inFileContain));
        scanner.close();
        System.exit(1);
    }

    /**
    * public  static printMenu
    */

    public static void printMenu() {
        System.out.println("\nCipher - Please enter an operation below.\n");
        System.out.print("R - Reverse all lines \n" + "F - Shift all letters forward \n"
            + "B - Shift all letters backward \n" + "Q - Quit \n");
        System.out.println("\noperation: \n");
    }
    /**
    * public  static printMenu
    * @param console values
    * @return lineCount
    */

    public static int line(Scanner console) {
        int lineCount = 0;
        while (console.hasNextLine()) {
            lineCount++;
            console.nextLine();
        }
        return lineCount;
    }

    /**
    * public  static readfile
    * @param console values
    * @param arr creating array values 
    *
    */

    public static void readFile(Scanner console, String[] arr) {
        String lineString = "";
        int lineCount = 0;
        while (console.hasNextLine()) {
            lineString = console.nextLine();
            arr[lineCount] = lineString;
            lineCount++;
        }
    }

    /**
    * public  static getInput file
    * @param name string values
    * @return input
    */

    public static Scanner getInput(String name) {
        Scanner input = null;
        while (input == null) {
            try {
                input = new Scanner(new FileInputStream(name));
            } catch (FileNotFoundException e) {
                System.out.println("Unable to access input file:" + name);
                System.exit(1);
            }
        }
        return input;
    }

    /**
    * public  static getOutput file
    * @param fileName string values
    * @return null values
    */

    public static PrintWriter getOutput(String fileName) {
        Scanner sc = new Scanner(System.in);
        String confirmation = "";
        FileOutputStream outputStream = null;
        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            System.out.println( fileName + " " + "exists - OK to overwrite (y,n)?: ");
            if (Character.toUpperCase(sc.next().charAt(0)) == 'Y') {
                try {
                    outputStream = new FileOutputStream(fileName);
                } catch (FileNotFoundException e) {
                    System.out.println("Cannot create output file");
                    System.exit(1);
                }
                PrintWriter output = new PrintWriter(outputStream, false);
                return output;
            } else {
                System.exit(1);
            }
        } else {
            try {
                outputStream = new FileOutputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Cannot create output file");
                System.exit(1);
            }
            PrintWriter output = new PrintWriter(outputStream, false);
            return output;
        }
        return null;

    }

    /**
    * Throws an IllegalArgumentException with the message "Invalid line"
    * if line is null
    * Creates and returns a copy of the String line with the characters in the reverse order
    * @param line String values
    * @return reverse
    * @throws IllegalArgumentException with the message "Invalid line"
    */

    public static String reverseLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Invalid line");
        }
        char[] letters = new char[line.length()];
        int letterIndex = 0;
        for (int i = line.length() - 1; i >= 0; i--) {
            letters[letterIndex] = line.charAt(i);
            letterIndex++;
        }
        String reverse = "";
        for (int i = 0; i < line.length(); i++) {
            reverse = reverse + letters[i];
        }
        return reverse;
    }

    /**
    * Throws an IllegalArgumentException with the message "Invalid line"
    * if line is null
    * Throws an IllegalArgumentException with the message "Invalid amount"
    * bif amount is less than 1 or greater than 25
    * NOTE: You must check for invalid parameters (arguments) in the order given above.
    * Creates and returns a copy of the String line such that each letter
    * has been replaced by the letter "amount" characters later in the
    * alphabet, wrapping around to the beginning of the alphabet, if necessary,
    * and preserving case
    * @param line String values
    * @param amount int values
    * @return lineFor
    * @throws IllegalArgumentException with the message "Invalid line"
    * @throws IllegalArgumentException with the message "Invalid amount"
    */

    public static String shiftLineLettersForward(String line, int amount) {
        if (line == null) {
            throw new IllegalArgumentException("Invalid line");
        }
        if (amount < 1 || amount > AMO_VALL) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount > AMO_VAL) {
            amount = amount % AMO_VAL;
        } else if (amount < 0) {
            amount = (amount % AMO_VAL) + AMO_VAL;
        }
        String lineFor = "";
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char ch1 = (char) (ch + amount);
                    if (ch1 > 'z') {
                        lineFor += (char) (ch - (AMO_VAL - amount));
                    } else {
                        lineFor += ch1;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char ch1 = (char) (ch + amount);
                    if (ch1 > 'Z') {
                        lineFor += (char) (ch - (AMO_VAL - amount));
                    } else {
                        lineFor += ch1;
                    }
                }
            } else {
                lineFor += ch;
            }
        }
        return lineFor;
    }

    /**
    * Throws an IllegalArgumentException with the message "Invalid line"
    * if line is null
    * Throws an IllegalArgumentException with the message "Invalid amount"
    * if amount is less than 1 or greater than 25
    * must check for invalid parameters (arguments) in the order given above.
    * Creates and returns a copy of the String line such that each letter
    * has been replaced by the letter "amount" characters earlier in the
    * alphabet, wrapping around to the end of the alphabet, if necessary,
    * and preserving case
    * @param line String values
    * @param amount int values
    * @return lineFor
    * @throws IllegalArgumentException with the message "Invalid line"
    @throws IllegalArgumentException with the message "Invalid amount"
    */

    public static String shiftLineLettersBackward(String line, int amount) {
        if (line == null) {
            throw new IllegalArgumentException("Invalid line");
        }
        if (amount < 1 || amount > AMO_VALL) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount > AMO_VAL) {
            amount = amount % AMO_VAL;
        } else if (amount < 0) {
            amount = (amount % AMO_VAL) + AMO_VAL;
        }
        String lineFor = "";
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char ch1 = (char) (ch - amount);
                    if (ch1 < 'a') {
                        lineFor += (char) (ch + (AMO_VAL - amount));
                    } else {
                        lineFor += ch1;
                    }
                } else if (Character.isUpperCase(ch)) {
                    char ch1 = (char) (ch - amount);
                    if (ch1 < 'A') {
                        lineFor += (char) (ch + (AMO_VAL - amount));
                    } else {
                        lineFor += ch1;
                    }
                }
            } else {
                lineFor += ch;
            }
        }
        return lineFor;
    }
}
