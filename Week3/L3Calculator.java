import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.GridLayout;
import java.text.ParseException;

/**
 * L3Calculator 
 * Author:      Pawel Wodyk 
 * Student ID:  B00122935 
 * Written on:  24/02/19
 * Description: 
 *  This application is a Calculator application 
 *  It has two text fields to enter left and right opperands and 5 buttons for add, subtract, divide, multiply and clear. 
 *  Clicking clear clears both text fields. 
 *  The result is displayed in the top text field. 
 *  User can continue the calculation by entering the number in th bottom text field and clicking desired operator.
 */

public class L3Calculator extends JFrame implements ActionListener {

    JTextField leftOpperand, rightOpperand;
    JButton btnAdd, btnSub, btnMult, btnDiv, btnClear;
    JPanel panel, leftSide, rightSide;

    public L3Calculator() {
        super("L3Calculator.java");

        panel = new JPanel(new GridLayout(1, 2));
        leftSide = new JPanel();
        rightSide = new JPanel();

        leftOpperand = new JTextField("", 10);
        rightOpperand = new JTextField("", 10);

        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMult = new JButton("*");
        btnDiv = new JButton("/");
        btnClear = new JButton("Clear");

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMult.addActionListener(this);
        btnDiv.addActionListener(this);
        btnClear.addActionListener(this);

        this.add(panel);
        panel.add(leftSide);
        panel.add(rightSide);

        leftSide.add(leftOpperand);
        leftSide.add(rightOpperand);

        rightSide.add(btnAdd);
        rightSide.add(btnSub);
        rightSide.add(btnMult);
        rightSide.add(btnDiv);
        rightSide.add(btnClear);

        setSize(250, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        double result = 0, tempLeft, tempRight;

        if (event.getSource() == btnClear) {
            leftOpperand.setText("");
        } else {
            try {
                tempLeft = Double.parseDouble(leftOpperand.getText());
                tempRight = Double.parseDouble(rightOpperand.getText());
                if (event.getSource() == btnAdd) {
                    result = tempLeft + tempRight;
                } else if (event.getSource() == btnSub) {
                    result = tempLeft - tempRight;
                } else if (event.getSource() == btnMult) {
                    result = tempLeft * tempRight;
                } else if (event.getSource() == btnDiv) {
                    result = tempLeft / tempRight;
                }
                leftOpperand.setText(String.valueOf(result));
                ;
            } catch (NumberFormatException nfEx) {
                JOptionPane.showMessageDialog(this, "The opperand need to be in the number format");
            }
        }
        rightOpperand.setText("");

    }

    public static void main(String args[]) {
        L3Calculator app = new L3Calculator();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}