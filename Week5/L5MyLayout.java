import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * L5MyLayout
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  18/02/19
 * Description:
 * 	
 * Methods:
 * 	 Swing application that create the GUI with 2 checkBoxes, 2 labels, 2fields on the left, and 3 buttons on the right
 */

public class L5MyLayout extends JFrame {

    JPanel rPanel, lPanel;
    JCheckBox ckbOne, ckbTwo;
    JLabel lblOne, lblTwo;
    JTextField txfOne, txfTwo;
    JButton btnOne, btnTwo, btnThr;


    public L5MyLayout() {
        super("Layout Application");

        this.setLayout(new FlowLayout());

        lPanel = new JPanel(new GridLayout(2,3));
        rPanel = new JPanel(new GridLayout(3,1));
        ckbOne = new JCheckBox("Snap to Grid");
        ckbTwo = new JCheckBox("Show Grid");
        lblOne = new JLabel("x:");
        lblTwo = new JLabel("y:");
        txfOne = new JTextField("8", 10);
        txfTwo = new JTextField("8", 10);

        btnOne = new JButton("OK");
        btnTwo = new JButton("Cancel");
        btnThr = new JButton("Help");

        lPanel.add(ckbOne);
        lPanel.add(lblOne);
        lPanel.add(txfOne);
        lPanel.add(ckbTwo);
        lPanel.add(lblTwo);
        lPanel.add(txfTwo);

        rPanel.add(btnTwo);
        rPanel.add(btnThr);
        rPanel.add(btnOne);

        this.add(lPanel);
        this.add(rPanel);


        setSize(500,200);
        setVisible(true);
    }

    public static void main(String args[]) {
        L5MyLayout app = new L5MyLayout();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}