import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * L9RandomLinkedList
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/03/19
 * Description:
 * 	    Write an application that populates an Integer Linked List with 12 random values between 1 and 100. 
 *      Perform a sort operation on the Linked List. 
 *      Display the contents of the Linked List unsorted and sorted. 
 *      Using some of class Collections methods find the largest 
 *          and smallest values in the List and display these values.
 */

public class L9RandomLinkedList {

    public static void main(String args[]) {

        Random ran = new Random();
        LinkedList<Integer> ll = new LinkedList<Integer>();
        
        for (int i = 0; i < 12; i++) {
            int num = ran.nextInt(100) + 1;
            ll.add(num);
        }

        System.out.println("Initial list: " + ll.toString() + "\n");

        Collections.sort(ll);

        System.out.println("Sorted List: " + ll.toString() + "\n");
        
        System.out.println("Max Value: " + Collections.max(ll));
        System.out.println("Min Value: " + Collections.min(ll));
    }
}