import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

/**
 * L6BookWriteFile
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/02/19
 * Description:
 *      Create a program that creates a sequential access file that mightbe used in a computer library system.
 *      This program should store the following details to a file:
 *          - Book Name
 *          - Book ISBN
 *          - Department
 *      Use the Frame object, pushbuttons and try and catch to assistwith your solution.
 */

public class L6BookWriteFile extends JFrame implements ActionListener {

    private JPanel mainPnl, btnPnl;
    private JTextField bookNameTxF, bookISBNTxF, departmentTxF;
    private JButton enterDataBtn;
    private DataOutputStream dataOut;
    private FileOutputStream fileOut;

    public L6BookWriteFile() {
        super("Library System - Write File");

        this.setLayout(new BorderLayout());

        try {
            fileOut = new FileOutputStream("books.dat");
            dataOut = new DataOutputStream(fileOut);
        } catch (IOException IoEx) {
            System.err.println("File could not be opened:\n" + IoEx.toString());
            JOptionPane.showMessageDialog(this, IoEx.getMessage(), IoEx.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        mainPnl = new JPanel(new GridLayout(3, 2, 15, 15));
        mainPnl.setBorder(new EmptyBorder(10,10,10,10) );
        btnPnl = new JPanel(new FlowLayout());

        bookNameTxF = new JTextField(10);
        bookISBNTxF = new JTextField(10);
        departmentTxF = new JTextField(10);

        enterDataBtn = new JButton("Enter Data");
        enterDataBtn.addActionListener(this);

        mainPnl.add(new JLabel("Book Name:"));
        mainPnl.add(bookNameTxF);
        mainPnl.add(new JLabel("Book ISBN:"));
        mainPnl.add(bookISBNTxF);
        mainPnl.add(new JLabel("Department:"));
        mainPnl.add(departmentTxF);
        btnPnl.add(enterDataBtn);

        this.add(mainPnl, BorderLayout.CENTER);
        this.add(btnPnl, BorderLayout.SOUTH);

        this.setSize(400, 200);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == enterDataBtn) {
            String tempName = bookNameTxF.getText();
            String tempISPN = bookISBNTxF.getText();
            String tempDept = departmentTxF.getText();
            if (tempName.isEmpty() || tempISPN.isEmpty() || tempDept.isEmpty() ) {
                JOptionPane.showMessageDialog(this, "Please make sure all data was entered", "Incomplete Data Input", JOptionPane.WARNING_MESSAGE);
            } else {
                this.writeStringToFile(tempName);
                this.writeStringToFile(tempISPN);
                this.writeStringToFile(tempDept);

                this.clearFields();
            }
        }
    }

    private void writeStringToFile(String str){
        try {
            dataOut.writeUTF(str);
            // throw new IOException("testing error massage");
        } catch (Exception ex) {
            System.err.println("Could not write to file:\n" + ex.toString());
            JOptionPane.showMessageDialog(this, ex.getMessage(), ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        bookNameTxF.setText("");
        bookISBNTxF.setText("");
        departmentTxF.setText("");
    }

    public static void main(String args[]) {
        L6BookWriteFile app = new L6BookWriteFile();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}