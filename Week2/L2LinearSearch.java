import java.util.Random;
import java.util.Scanner;

/**
 * L2LinearSearch
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  28/01/19
 * Description:
 * 	This application defines and initialise an array of type int with the following numbers: "10, 12, 16, 18, 21, 98, 13, 76, 77, 55". 
 * Then it invite the user to enter a searched number.
 * Next it performs a linear search of the unsorted array to determine if the number entered is found in the array. 
 * If the number is found, displais word "found" on the screen.
 * else if not found, display words "not found" on the screen.	
 */

public class L2LinearSearch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inNumber;
        int[] numbers = {10, 12, 16, 18, 21, 98, 13, 76, 77, 55};
        //  int[] numbers = initIntegerArray(20);

        //System.out.println(displayValues(numbers));
        // System.out.println(findInArray(13, numbers));

        System.out.println("Please enter the number you would like to find:");
        inNumber = Integer.parseInt(sc.next());
        System.out.println(findInArray(inNumber, numbers));

    }

    //finds number in the array using linear search
    private static String findInArray(int find, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (find == array[i]) {
                return "found at index position [" + i + "]";
            }
        }
        return "not found";
    }

    // this method initialize array of random numbers for testing
    private static int[] initIntegerArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    // this method return values from array
    private static String displayValues(int[] nums) {
        String outString = "Your numbers are:\n";
        for (int num : nums) {
            outString += num + "; ";
        }

        return outString + "\n";
    }
}