import java.awt.*;
import javax.swing.*;

/**
 * L8Painter
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  11/03/19
 * Description:
 *      Adapt the Painter.java and PainterPanel.java program to draw red ovals of size 10 x 10 pixels.
 */

public class L8Painter {

    public static void main(String args[]) {
        // create JFrame
        JFrame application = new JFrame("Draw Red Oval Application"); //EDIT: Changed the title

        L8PainterPanel paintPanel = new L8PainterPanel(); // create paint panel
        application.add(paintPanel, BorderLayout.CENTER); // in center

        // create a label and place it in SOUTH of BorderLayout
        application.add(new JLabel("Drag the mouse to draw"), BorderLayout.SOUTH);

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(400, 200); // set frame size
        application.setVisible(true); // display frame
    } // end main
} // end class Painter