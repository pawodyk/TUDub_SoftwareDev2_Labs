import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * L6FileInput
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/02/19
 * Description:
 *      Application reads the numbers that are written to "file1.dat"
 *      Displays the numbers on the screen.
 * 	
 */

public class L6FileInput {

    public static void main(String args[]) {

        DataInputStream dataIn;

        try {
            dataIn = new DataInputStream(new FileInputStream("file1.dat"));
            try {
                while (dataIn.available() > 0) {
                    System.out.print(dataIn.readInt() + " ");
                }
                System.out.println();
            } finally {
                System.err.println("Closing stream...");
                dataIn.close();
            }

        } catch (FileNotFoundException fnfEx) {
            System.err.println("Could not find a file\nERROR:\n" + fnfEx.toString());
        } catch (IOException ioEx) {
            System.err.println("Exception happened\nERROR:\n" + ioEx.toString());
        }
    }
}