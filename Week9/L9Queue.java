import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * L9Queue
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/03/19
 * Description:
 * 	    Write an application that implements a Queue.
 *      Push the days of the week onto the Queue.
 *      Print the contents of the Queue.
 *      Remove Saturday and Sunday from the Queue. 
 *      Print the contents of the Queue.	
 */

public class L9Queue {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Queue<String> que = new LinkedList<String>();

        try {
            que.add("Sunday");
            que.add("Saturday");
            que.add("Friday");
            que.add("Thursday");
            que.add("Wednesday");
            que.add("Tuesday");
            que.add("Monday");
            
        } catch (IllegalStateException isEx) {
            System.err.println(isEx.toString());
        }

        System.out.println(que.toString());
        
        System.out.println();

        System.out.println("Removing: " + que.poll());
        System.out.println("Removing: " + que.poll());

        System.out.println();

        System.out.println(que.toString());
        

        sc.close();
    }
}