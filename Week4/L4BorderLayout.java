import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.*;

/**
 * L4BorderLayout
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on: 11/02/19
 * Description:
 * 	Swing application that extends a JFrame and contains a panel with 5 buttons: north, south, east, west, middle.
 * When the user clicks on north, the north button disappears. All other buttons are displayed.
 * When the user clicks on south, the south button disappears. All other buttons are displayed.
 * When the user clicks on east, the east button disappears. All other buttons are displayed.
 * When the user clicks on wast, the wast button disappears. All other buttons are displayed.
 * When the user clicks on middle, the middle button disappears. All other buttons are displayed.
 */

public class L4BorderLayout extends JFrame implements ActionListener {

    JPanel pMain;
    JButton btnNorth, btnSouth, btnEast, btnWest, btnMiddle;
    JButton btns[] = { btnNorth, btnSouth, btnEast, btnWest, btnMiddle };
    String btnNames[] = { "north", "south", "east", "west", "middle" };
    String btnLocations[] = { BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.EAST, BorderLayout.WEST,
            BorderLayout.CENTER };

    public L4BorderLayout() {
        super("L4BorderLayout");
        pMain = new JPanel(new BorderLayout(15, 15));
        this.add(pMain);

        if (btns.length == btnNames.length && btns.length == btnLocations.length) {
            for (int i = 0; i < btns.length; i++) {
                btns[i] = new JButton(btnNames[i]);
                btns[i].addActionListener(this);
                pMain.add(btns[i], btnLocations[i]);
            }
        }

        setSize(500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton el : btns) {

            if (e.getSource() == el)
                el.setVisible(false);
            else
                el.setVisible(true);
        }
        validate();

    }

    public static void main(String args[]) {
        L4BorderLayout app = new L4BorderLayout();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}