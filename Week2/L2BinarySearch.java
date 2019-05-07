import java.util.Scanner;

/**
 * L2BinarySearch
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  24/02/19
 * Description:
 * 	Application defins an array of type String and Initialise the array with the following words: 
 *          "apple, banana, carrot, cat, dog, elephant, goose, hen, monkey, robot". 
 * Invites the user to enter a search word.
 * Next Metod BinarySearch performs a binary search of the sorted array to determine if the word entered is found in the array. 
 * The method will return -1 if not found.
 * If found it returns the element position of the word in the array.
 * If the word is found, displais word "found" on the screen.
 * If the word is not found, displays words "not found" on the screen.
 */

public class L2BinarySearch {
    static Scanner sc;

    public static void main(String[] args) {

        String[] myArray = { "apple", "banana", "carrot", "cat", "dog", "elephant", "goose", "hen", "monkey", "robot" };
        int result;
        boolean isFin;

        // System.out.println(myArray[2].compareTo(myArray[3])); //negative
        // System.out.println(myArray[5].compareTo(myArray[3])); //positive
        // System.out.println(myArray[3].compareTo(myArray[3])); // equal
        
        // testSearch(myArray); // used for testing.

        do{
            String input = inputString();
            if(input.equals("exit")){
                isFin = true;
            }
            else {
                isFin = false; 
                result = findString(myArray, input);

                if (result >= 0) {
                    System.out.println("found at index postition " + result);
                } else {
                    System.out.println("not found");
                }
            }            
        } while(!isFin);
    }

    //binary search of the String provided
    private static int findString(String[] arr, String find) {
        int iMax = arr.length, iMin = 0, pointer; // index Max; index Min, index Middle
        //int iteration = 0;
        while (iMin <= iMax) {
            pointer = (iMax+iMin)/2;
            //System.out.println(++iteration +" ["+ iMin +"; "+ pointer +"; "+ iMax +"]" ); //for debuging purpose
            
            if (find.equals(arr[pointer])){
                return pointer;
            }else if (find.compareTo(arr[pointer])>0) { // if the value is higher then a pointer:
                iMin= pointer;                          // -> set min value to pointer value
            } else {                                    // if the value is lower:
                iMax = pointer;                         // -> set max value to the pointer
            }
            //if (iteration > 10) break;    //for debuging purpose prevent infinite loop
        }
        return -1;
    }

    //tests each value in array
    private static void testSearch(String[] arr) {
        for (String var : arr) {
            System.out.println(findString(arr, var) +": "+ var);
        }
    }

    // this method asks user to input data
    private static String inputString() {
        sc = new Scanner(System.in);
        String outString;

        System.out.println("\nPlease enter Word to find or enter \"exit\":");
        outString = sc.nextLine();
        // sc.close();
        return outString;
    }
}