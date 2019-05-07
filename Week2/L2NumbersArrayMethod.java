import java.util.Random;
import java.util.Scanner;

/**
 * L2NumbersArrayMethod
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  28/01/19
 * Description:
 * 	This application calls a method inputNumbers which asks the user to enter 5 numbers. 
 * When the numbers are entered, they are saved in an array called numbers.
 * Next the method displayValues is called from println function to display the numbers to the console.
 * 	
 */


public class L2NumbersArrayMethod {
    static Scanner sc;
    public static void main(String[] args) {
        
        int[] numbers = inputNumbers(5);
        // int[] numbers = initIntegerArray(5); // for testing purposes - creates array of random numbers

        System.out.println();
        System.out.println(displayValues(numbers));

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

    // this method allow user to input values to array
    private static int[] inputNumbers(int size){
        sc = new Scanner(System.in);
        int[] nums = new int[size];
        
        System.out.println("Please enter " + size + " numbers:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Please enter the number at " + i);
            nums[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        return nums;
    }

    // this input display values from the array
    private static String displayValues(int[] nums) {
        String outString = "Your numbers are:\n";
        for (int num : nums) {
            outString += num + "\n"; 
        }
        
        return outString;
    }
}