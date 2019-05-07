import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import java.util.StringTokenizer;

/**
 * L4StringTokeniser
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  11/02/19
 * Description:
 * 	A swing application that accepts a sentence from the user in a textfield. 
 *  It then tokenises the sentence using StringTokeniser.
 *  Prints out the number of tokens and the tokens line by line. 
 *  Uses BorderLayout.
 */

public class L4StringTokeniser extends JFrame implements ActionListener {

    JPanel topPanel;
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel instructions;
    JTextField userInputField;


    public L4StringTokeniser() {
        super("String Tokeniser Application");
        this.setLayout(new BorderLayout());
        topPanel = new JPanel(new GridLayout(2, 1));
        instructions = new JLabel("Enter String that you want to Tokenise");
		userInputField = new JTextField();

		textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
		
        userInputField.addActionListener(this);

        this.add(topPanel, BorderLayout.NORTH);
		topPanel.add(instructions);
        topPanel.add(userInputField);
        this.add(scrollPane, BorderLayout.CENTER);
		
        setSize(500,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		StringTokenizer strTokenizer = new StringTokenizer(e.getActionCommand());

        int count = 0;
        String output = "";

		while (strTokenizer.hasMoreTokens()){
            count++;
			output = output.concat(count + ":\t" + strTokenizer.nextToken() + "\n");
        }
        textArea.append("Number of tokens: " + count + "\n\nTokens:\n" + output);
    }

    public static void main(String args[]) {
        L4StringTokeniser app = new L4StringTokeniser();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}