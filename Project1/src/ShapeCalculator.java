import java.util.Scanner;
/**
 * This project must prompt the user for the shape type(Cube, Cylinder, Sphere)
 * and values needed for the calculation.
 *
 * @author Rabin Paudel
 *
 */

public class ShapeCalculator {
     /**
     * Starts Project with class ShapeCalculator
     *
     * @author Rabin Paudel
     *
     * Takes user input to determine different values of ShapeCalculator.
     *
     * @param args command line arguments
     */
    public static final int CUBE_SURFACE_AREA_CONSTANT = 6;
    /**
     * CUBE_SURFACE_AREA_CONSTANT
     */

    public static final int CUBE_VOLUME_COEFFICIENT = 3;
    /**
     * constant values CUBE_VOLUME_COEFFICIENT
     */

    public static final int SPHERE_SURFACE_AREA_CONSTANT = 4;
    /**
     * constant values SPHERE_SURFACE_AREA_CONSTANT
     */

    public static final double SPHERE_VOLUME_CONSTANT = 4.0 / 3.0;
    /**
     * constant values SPHERE_VOLUME_CONSTANT
     */

    public static final int SPHERE_VOLUME_COEFFICIENT = 3;
    /**
     * Initiates the program and asks for user input.
     *
     * @param args command line arguments
     */

    public static void main (String [] args) {
        Scanner scnr  = new Scanner (System.in);
        System.out.print("Shape (C-Cube, Y-Cylinder, S-Sphere:");
        String val = scnr.nextLine();
        char value;
        value = val.charAt(0);
        if (val.length() > 1){
            System.out.println("Invalid shape");
            System.exit(1);
        }
        switch (value) {
            case 'C':
            case 'c':
                break;
            case 'Y':
            case 'y':
                break;
            case 'S':
            case 's':
                break;
            default: System.out.println ("Invalid shape");
                System.exit(1);
        }
        System.out.print ("Option (S-Surface Area, V-Volume): ");
        String vall = scnr.nextLine();
        char values;
        values = vall.charAt(0);
        if (vall.length() > 1){
            System.out.println("Invalid option");
            System.exit(1);
        }
        switch (values) {
            case 'S':
            case 's':
                break;
            case 'V':
            case 'v':
                break;
            default : System.out.println ("Invalid option");
                System.exit(1);
        }
        if ((value == 'C' || value == 'c') && (values == 'S' || values == 's')) {
            System.out.print ("Side Length: ");
            int length = scnr.nextInt();
            if (length <= 0){
                System.out.print("Invalid value");
                System.exit(1);
            }
            double newArea = CUBE_SURFACE_AREA_CONSTANT * length * length;
            System.out.printf( "%.2f", newArea);
        }
        else if ((value == 'C' || value == 'c') && (values == 'V' || values == 'v')){
            System.out.print ("Side Length: ");
            int length = scnr.nextInt();
            if (length <= 0){
                System.out.print("Invalid value");
                System.exit(1);
            }
            double nexVolume = 1 * Math.pow(length,CUBE_VOLUME_COEFFICIENT);
            System.out.printf("%.2f", nexVolume);
        }
        else if ((value == 'Y' || value == 'y') && (values == 'S' || values == 's')){
            System.out.print("Radius:");
            int radius = scnr.nextInt();
            if (radius <= 0){
                System.out.print("Invalid value");
                System.exit(1);
            }
            System.out.print("Height: ");
            int height = scnr.nextInt();
            if (height <= 0){
                System.out.print("Invalid value");
                System.exit(1);
            }
            double surfaceArea;
            surfaceArea = (2 * Math.PI * radius * height + 2 * Math.PI * radius * radius);
            System.out.printf("%.2f", surfaceArea);
        }
        else if ((value == 'Y' || value == 'y') && (values == 'V' || values == 'v') ){
            System.out.print("Radius:");
            int radius = scnr.nextInt();
            if (radius <= 0){
                System.out.println("Invalid value");
                System.exit(1);
            }
            System.out.print ("Height: ");
            int height = scnr.nextInt();
            if (height <= 0){
                System.out.print("Invalid value");
                System.exit(1);
            }
            double volume = Math.PI * radius * radius * height;
            System.out.printf("%.2f", volume);

        }

        else if ((value == 'S' || value == 's') && (values == 'S' || values == 's') ){
            System.out.print("Radius:");
            int radius = scnr.nextInt();
            if (radius <= 0){
                System.out.println("Invalid value");
                System.exit(1);
            }
            double surfaceArea = SPHERE_SURFACE_AREA_CONSTANT * Math.PI * radius * radius;
            System.out.printf("%.2f", surfaceArea);

        }
        else if ((value == 'S' || value == 's') && (values == 'V' || values == 'v') ){
            System.out.print("Radius:");
            int radius = scnr.nextInt();
            if (radius <= 0){
                System.out.println("Invalid value");
                System.exit(1);
            }
            double volum;
            volum = SPHERE_VOLUME_CONSTANT * Math.PI * Math.pow (radius, SPHERE_VOLUME_COEFFICIENT);
            System.out.printf("%.2f", volum);
        }
        else {
            System.out.println("Invalid value");
        }

    }
}
