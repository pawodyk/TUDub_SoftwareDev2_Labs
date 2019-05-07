import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.FlowLayout;

//import java.util.Map;

/**
 * L5MyList
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  18/02/19
 * Description:
 * 	Application contains a JComboBox with the following colors:
 *      "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow"
 * It has event handling procedures that when an item is double-clicked on the list the background color of the application changes to the appropriate color
 */

public class L5MyList extends JFrame implements ItemListener {

    JFrame window = new JFrame("List Application");
    JPanel panel;
    JComboBox cBox;

    String colorNames[] = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
            "Pink", "Red", "White", "Yellow" };
    Color colorValues[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,  Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    
    // Map<String, Color> colors = new TreeMap();
    
    public L5MyList() {
        
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();

        cBox = new JComboBox(colorNames);
        cBox.setMaximumRowCount(5);
        cBox.addItemListener(this);

        panel.add(cBox);
        window.add(panel, BorderLayout.CENTER);

        window.setSize(500, 300);
        window.setVisible(true);
    }

    // private void populateMap(){
    //     String colName[] = { "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange",
    //         "Pink", "Red", "White", "Yellow" };
    //     Color colVal[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,  Color.CYAN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
    //     for (int i = 0; i < max; i++) {
    //         colors.put(colName[i], colVal[i]);
    //     }
    // }

    @Override
    public void itemStateChanged(ItemEvent e) {
        for (int i = 0; i < colorValues.length; i++) {
            if (e.getItem().equals(colorNames[i])) {
                panel.setBackground(colorValues[i]);
            }
        }

        //window.setBackground(Color.black);

    }    

    public static void main(String args[]) {
        new L5MyList();
        
    }
}