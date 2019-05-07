
//binary search of an array

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;

public class L3BinarySearch extends Applet implements ActionListener {
    String a[] = new String[] { "apple", "banana", "carrot", "cat", "dog", "elephant", "goose", "hen", "monkey",
            "robot"};
    int element;
    String searchKey;
    int xPosition; // applet horizontal drawing position
    int yPosition; // applet vertical drawing position
    Label enterLabel, resultLabel;
    TextField enter, result;
    boolean timeToSearch = false;

    public void init() {

        System.out.println("String test array contains...");

        // loop used to display elements to a dos screen
        for (int i = 0; i < a.length; i++) {
            System.out.println("Element " + (i) + " is " + a[i]);
        }
        enterLabel = new Label("Enter Key");
        add(enterLabel);

        enter = new TextField(5);
        enter.addActionListener(this);
        add(enter);

        resultLabel = new Label("Result");
        add(resultLabel);

        result = new TextField(22);
        result.setEditable(false);
        add(result);
    }

    public void paint(Graphics g) {

        if (timeToSearch) // prevents search 1st time called
        {
            element = binarySearch(searchKey);

            if (element != -1)
                result.setText("Found value in element " + element);
            else
                result.setText("Value not Found");
        }
    }

    public void actionPerformed(ActionEvent e) {
        timeToSearch = true;
        xPosition = 25;
        yPosition = 75;

        searchKey = e.getActionCommand().toString();
        repaint();

    }

    // Binary search method
    public int binarySearch(String key) {
        int first = 0;
        int last = a.length;
        int iteration = 0;

        while (first < last) {            
            int mid = first + ((last - first) / 2);
            System.out.println(++iteration + " [" + first + "; " + mid + "; " + last + "]"); // for debuging purpose
            if (key.compareTo(a[mid]) < 0) {
                last = mid;
            } else if (key.compareTo(a[mid]) > 0) {
                first = mid + 1;
            } else {
                System.out.println();
                return mid;
            }
        }
        System.out.println();
        return -1;
    }

}