import java.util.Random;
import java.util.Scanner;

/**
 * L2BubbleSort
 * used to test the most efficent way to write Bubble Sort Algorythm
 */
public class PrototypeL2BubbleSort {
    static Scanner sc;

    public static void main(String[] args) {

        // int[] numbers = inputNumbers(10);
        int[] numbers = initIntegerArray(1000);
        // int[] numbers = {10,9,8,7,6,5,4,3,2,1};
        
        
        System.out.println("\nNumbers before Sorting: " + displayValues(numbers));
        // System.out.println("\nNumbers after Sorting: " + displayValues(bubbleSort(numbers)));
        // System.out.println("\nNumbers after Sorting: " + displayValues(bubbleSort2(numbers)));
        // System.out.println("\nNumbers after Sorting: " + displayValues(bubbleSort3(numbers)));
        System.out.println("\nNumbers after Sorting: " + displayValues(sort(numbers)));

    }

    private static int[] initIntegerArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }
        return arr;
    }

    private static int[] inputNumbers(int size) {
        sc = new Scanner(System.in);
        int[] nums = new int[size];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Please enter the number at index position [" + i + "]");
            nums[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        return nums;
    }

    private static String displayValues(int[] nums) {
        String outString = "Your numbers are:\n";
        for (int num : nums) {
            outString += num + "; ";
        }

        return outString + "\n";
    }

    private static String displayValues(int[] nums, int index) {
        return "Your number at index position [" + index + "] is:\t" + nums[index];
    }

    // Bubble sort : First Try
    private static int[] bubbleSort(int[] n) {
        int temp;
        boolean sorted;
        int outCount = 0, inCount =0;
        do {
            sorted = true;
            for (int i = 0; i < n.length - 1; i++) {
                if (n[i] > n[i + 1]) {
                    sorted = false;

                    temp = n[i];
                    n[i] = n[i + 1];
                    n[i + 1] = temp;
                }
                inCount++;
            }
            outCount++;
        } while (!sorted);
        System.out.println("Method 1 buble sort alg iterated : \ninner: " + inCount + "\nouter: " + outCount);
        return n;
    }

    // Bubble sort Method 2
    private static int[] bubbleSort2(int[] n) {
        int temp;
        int outCount = 0, inCount = 0;
        for (int i = 0; i < n.length - 1; i++) {
            // sorted = true;
            for (int j = 0; j < (n.length - i - 1); j++) {
                if (n[j] > n[j + 1]) {
                    // sorted = false;

                    temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
                inCount++;
            }
            outCount++;
        }

        System.out.println("Method 2 buble sort alg iterated : \ninner: " + inCount + "\nouter: " + outCount);
        return n;
    }

    // Bubble sort Method Class
    private static int[] bubbleSort3(int[] n) {
        int temp;
        int outCount = 0, inCount = 0;
        for (int i = 1; i < n.length; i++) {
            for (int j = 0; j < n.length - 1; j++) {
                if (n[j] > n[j + 1]){
                    temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
                inCount++;
            }
            outCount++;
        }

        System.out.println("Class Method buble sort alg iterated : \ninner: " + inCount + "\nouter: " + outCount);
        return n;
    }

    // Bubble sort Method : Final Version - best performance
    private static int[] sort(int[] n) {
        int temp;
        int outCount = 0, inCount = 0;
        boolean sorted;
        for (int i = 0; i < n.length - 1; i++) {
            sorted = true;
            for (int j = 0; j < (n.length - i - 1); j++) {
                if (n[j] > n[j + 1]) {
                    sorted = false;

                    temp = n[j];
                    n[j] = n[j + 1];
                    n[j + 1] = temp;
                }
                inCount++;
            }
            outCount++;
            if (sorted) { 
                break;
            }
        }

        System.out.println("Final Method buble sort alg iterated : \ninner: " + inCount + "\nouter: " + outCount);
        return n;
    }

}