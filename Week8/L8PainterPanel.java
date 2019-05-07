import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

/**
* L8PainterPanel
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  11/03/19
 * Description:
 *      Adapt the PainterPanel.java program to draw red ovals of size 10 x 10 pixels.
 */

public class L8PainterPanel extends JPanel {

    private int pointCount = 0; // count number of points

    // array of 10000 java.awt.Point references
    private Point points[] = new Point[10000];

    // set up GUI and register mouse event handler
    public L8PainterPanel() {
        // handle frame mouse motion event
        addMouseMotionListener(

                new MouseMotionAdapter() // anonymous inner class
                {
                    // store drag coordinates and repaint
                    public void mouseDragged(MouseEvent event) {
                        if (pointCount < points.length) {
                            points[pointCount] = event.getPoint(); // find point
                            pointCount++; // increment number of points in array
                            repaint(); // repaint JFrame
                        } // end if
                    } // end method mouseDragged
                } // end anonymous inner class
        ); // end call to addMouseMotionListener
    } // end PaintPanel constructor

    // draw oval in a 10-by-10 bounding box at specified location on window
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clears drawing area
        g.setColor(Color.RED); // EDIT: added color to paint method
        // draw all points in array
        for (int i = 0; i < pointCount; i++) {

            g.fillOval(points[i].x, points[i].y, 10, 10);   // EDIT: changed the size of the painter 
        }
    } // end method paint
} // end class PaintPanel
