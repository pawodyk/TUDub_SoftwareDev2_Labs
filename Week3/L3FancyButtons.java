import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * L3FancyButtons
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  24/02/19
 * Description:
 * 	This application contains a frame and container.
 *  It has three buttons in the container.
 *      The first button is a plain button and has no icon.
 *      The second button is a fancy button and contains an icon.
 *      The third button is a fancy button and contains an icon and has a different roll over icon.
 *  When each button is clicked it display dialog box showing which button was clicked on.
 */

public class L3FancyButtons extends JFrame{

    static JFrame frame;
    Container container;
    JButton btnOne, btnTwo, btnThree;
    Icon icon = new ImageIcon("./bug1.gif");
		Icon iconHover = new ImageIcon("./bug2.gif");

    public L3FancyButtons() {

        frame = new JFrame("Fancy Buttons App");
        container = new Container();
        container.setLayout(new FlowLayout());

        ButtonEvent eventHandler = new ButtonEvent();

        

        btnOne = new JButton("Plain Button");
        btnTwo = new JButton("Fancy Button", icon);
        btnThree = new JButton("FAncy Button with roll over icon", icon);
        btnThree.setRolloverIcon(iconHover);

        btnOne.addActionListener(eventHandler);
        btnTwo.addActionListener(eventHandler);
        btnThree.addActionListener(eventHandler);

        frame.add(container);
        container.add(btnOne);
        container.add(btnTwo);
        container.add(btnThree);

        frame.setSize(600,200);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        new L3FancyButtons();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "You pressed " + e.getActionCommand());
		}
	}
}