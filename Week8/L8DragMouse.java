import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.*;

/**
 * L8DragMouse
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  11/03/19
 * Description:
 *      Write an application that allows the user to draw rectangles by dragging the mouse.
 */

public class L8DragMouse extends JFrame implements MouseListener, MouseMotionListener {
    private int x, y;
    private int brushSize = 30;

    public L8DragMouse() {
        super("Draw Rectangles Application");
        setSize(1000, 800);
        setVisible(true);

        String input = JOptionPane.showInputDialog(this, "Click on the canvas to draw the rectangles\n\nPlease enter the size of the brush(DEFAULT:30)\n");
        try {
            brushSize = Integer.parseInt(input);
        } catch (Exception e) {
            System.err.println("Invalid input");
            brushSize = 30;
        }

        addMouseListener(this);
		addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
		g.fillRect(x, y, brushSize, brushSize);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
		y = e.getY();
		repaint();
    }

    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

    public static void main(String args[]) {
        L8DragMouse app = new L8DragMouse();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}