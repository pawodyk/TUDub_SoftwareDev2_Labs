import java.util.Scanner;
import java.util.Stack;

/**
 * L9StackAnimals
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/03/19
 * Description:
 * 	    Write an application that implements a Stack. 
 *      Push the following animals into the Stack: 
 *          Dog, Cat, Rabbit, Giraffe, Elephant, Cow, Pelican, Goldfish
 *      Implement a method to search the Stack. 
 *      Allow the user to enter an animal name and print "Found" and its stack position.
 *      Otherwise print "Not found".	
 */

public class L9StackAnimals {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<String>();
        String[] animals = {"Dog", "Cat", "Rabbit", "Giraffe", "Elephant", "Cow", "Pelican", "Goldfish"};

        for (String item : animals) {
            st.push(item);
        }

        System.out.print("What animal you would like to find? ");
        
        String key = sc.nextLine();

        int result = st.search(key);

        if (result == -1) {
            System.out.println("Animal Not Found");
        } else {
            System.out.println("Animal \""+ key + "\" found at index position: [" + result + "]");
        }

        sc.close();
        
    }
}