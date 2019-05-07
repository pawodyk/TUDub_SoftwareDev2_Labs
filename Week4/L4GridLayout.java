import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

/**
 * L4GridLayout
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  11/02/19
 * Description:
 * Swing application that contains 8 Buttons. 
 * The Button objects initially are arranged in a grid with two rows and four columns.
 * When the user clicks a button the layout toggles to a fourrow, 2 column layout.
 * When the user clicks a button again the layout toggles to a two row, four column layout.
 */

public class L4GridLayout extends JFrame implements ActionListener {

    //String[] btnNames = new String[8];
    JButton[] btnArray;
    boolean toggleLayout = true;

    public L4GridLayout() {
        super("Grid Layout Button Application ");

        this.setLayout(new GridLayout(2,4,5,5));

        btnArray = new JButton[8];

        for (int i = 0; i < btnArray.length; i++) {
           
            btnArray[i] = new JButton("Button " + i);
            btnArray[i].addActionListener(this);
            add(btnArray[i]);
        }


        setSize(500,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(toggleLayout){
            setLayout(new GridLayout(4,2,5,5));
        }else {
            setLayout(new GridLayout(2,4,5,5));
        }
        toggleLayout = !toggleLayout;

        validate();   
    }

    public static void main(String args[]) {
        L4GridLayout app = new L4GridLayout();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}