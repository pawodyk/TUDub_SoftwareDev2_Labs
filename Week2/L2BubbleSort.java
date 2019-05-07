import java.util.Random;
import java.util.Scanner;

/**
 * L2BubbleSort
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  28/01/19
 * Description:
 * This application obtains a series of numbers from the user and store in an array.
 * Then the bubble sort algorithm is used to to sort the array.
 * Sorted values are then displayed.
 */

public class L2BubbleSort {
    static Scanner sc;

    public static void main(String[] args) {

        int[] numbers = inputNumbers(10);
        // int[] numbers = initIntegerArray(1000); //

        // System.out.println("\nNumbers before Sorting: " + displayValues(numbers));
        System.out.println("\nNumbers after Sorting: " + displayValues(sort(numbers)));

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

    //this method asks user to input data
    private static int[] inputNumbers(int size) {
        sc = new Scanner(System.in);
        int[] nums = new int[size];

        System.out.println("Please enter " + size + " numbers:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Please enter the number at index position [" + i + "]");
            nums[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        return nums;
    }

    //this method return values from array
    private static String displayValues(int[] nums) {
        String outString = "Your numbers are:\n";
        for (int num : nums) {
            outString += num + "; ";
        }

        return outString + "\n";
    }

    // overided method displaing single valueS
    private static String displayValues(int[] nums, int index) {
        return "Your number at index position [" + index + "] is:\t" + nums[index];
    }

    // Bubble sort Method : Final Version - for other tests check PrototypeL2BubbleSort.java
    private static int[] sort(int[] n) {
        int temp;
        boolean sorted;
        for (int i = 0; i < n.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < (n.length - i - 1); j++) { // the (array.length -i -1) ensures that after each itteration the code do not check the last value wich would be already sorted after previous itteration
                if (n[j] > n[j + 1]) {
                    sorted = false; 

                    temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
            }
            if (sorted) { // this code make sure that the code will not itterate if the array is already sorted
                break;
            }
        }
        return n;
    }
}