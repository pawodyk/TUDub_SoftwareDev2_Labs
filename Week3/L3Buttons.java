import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 * L3Buttons
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  24/02/19
 * Description:
 * This application has three buttons: Blue, Green, Red. 
 * It has event handling procedures that:
 *  When the blue button is clicked:
 *      - The background colour of the application changes to blue
 *      - The message "Blue as a summer's sky" is printed on the application
 *      - The blue button is disabled other buttons are enabled
 *  When the green button is clicked: 
 *      - The background colour of the application changes to green
 *      - The message "Green as the grass" is printed on the application
 *      - The green button is disabled. Other are enabled
 *  When the red button is clicked:
 *      - The background colour of the application changes to red
 *      - The message "Red as a beetroot" is printed on the application
 *      - The red button is disabled. The blue and green buttons are enabled
 */

public class L3Buttons extends JFrame implements ActionListener {

    JPanel btnsPanel, displayPanel;
    JButton btnBlue, btnGreen, btnRed;
    JLabel text;

    public L3Buttons() {
        super("Color Buttons");

        this.setLayout(new BorderLayout());
        btnsPanel = new JPanel(new GridLayout(1,3));
        displayPanel = new JPanel(new FlowLayout());

        this.add(btnsPanel, BorderLayout.NORTH);
        this.add(displayPanel, BorderLayout.CENTER);

        text = new JLabel("Please press a button");

        btnBlue = new JButton("Blue");
        btnGreen = new JButton("Green");
        btnRed = new JButton("Red");

        btnsPanel.add(btnBlue);
        btnsPanel.add(btnGreen);
        btnsPanel.add(btnRed);

        displayPanel.add(text);

        btnBlue.addActionListener(this);
        btnGreen.addActionListener(this);
        btnRed.addActionListener(this);

        setSize(500,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {

        btnBlue.setEnabled(true);
        btnGreen.setEnabled(true);
        btnRed.setEnabled(true);

        text.setForeground(Color.BLACK);

        switch (event.getActionCommand()) {
            case "Blue":
                btnBlue.setEnabled(false);
                displayPanel.setBackground(Color.BLUE);
                text.setForeground(Color.WHITE);
                text.setText("Blue as a summer's sky");
                break;
            case "Green":
                btnGreen.setEnabled(false);
                displayPanel.setBackground(Color.GREEN);
                text.setText("Green as the grass");
                break;
            case "Red":
                btnRed.setEnabled(false);
                displayPanel.setBackground(Color.RED);
                text.setText("Red as a beetroot");
                break;
            default:
                displayPanel.setBackground(Color.WHITE);
                text.setForeground(Color.BLACK);
                text.setText("");
                break;
        }
    }

    public static void main(String args[]) {
        L3Buttons app = new L3Buttons();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
