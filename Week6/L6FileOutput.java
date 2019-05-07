import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * L6FileOutput
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/02/19
 * Description:
 *      This application creates an array called numbers with the following numbers: 2,4,6,2,4,5,9,10,12,89.
 *      It then writes these numbers to a file called file1.dat
 * 	
 */

public class L6FileOutput {

    public static void main(String args[]) {
        int[] numbers = { 2, 4, 6, 2, 4, 5, 9, 10, 12, 89 };

        DataOutputStream dataOut;

        try {
            dataOut = new DataOutputStream(new FileOutputStream("file1.dat"));

            try {
                for (int var : numbers) {
                    dataOut.writeInt(var);
                    System.out.println("Writing " + var + " to file");
                    // throw new IOException();
                    // throw new FileNotFoundException();
                }
            } finally {
                System.out.println("Closing stream...");
                dataOut.close();
            }

        } catch (FileNotFoundException fnfEx) {
            System.err.println("Could not find a file\nERROR:\t" + fnfEx.toString());
        } catch (IOException ioEx) {
            System.err.println("Exception cought\nERROR:\t" + ioEx.toString());
        }
    }
}