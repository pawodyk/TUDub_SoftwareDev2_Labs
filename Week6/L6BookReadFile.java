import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

/**
 * L6BookReadFile
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  25/02/19
 *      Once you have created the program to store the book details to a file (L7bookwritefile.java), 
 *      the next step is to create a program that can read the details from the file.
 *      In this program the following details should be displayed: 
 *        - Book Name
 *        - Book ISBN
 *        - Department
 */

public class L6BookReadFile extends JFrame implements ActionListener {

    private JPanel mainPnl, btnPnl;
    private JTextField bookNameTxF, bookISBNTxF, departmentTxF;
    private JButton readDataBtn;
    private DataInputStream dataIn;
    private FileInputStream fileIn;

    public L6BookReadFile() {
        super("Library System - Read File");

        this.setLayout(new BorderLayout());

        try {
            fileIn = new FileInputStream("books.dat");
            dataIn = new DataInputStream(fileIn);
        } catch (IOException IoEx) {
            System.err.println("File could not be opened:\n" + IoEx.toString());
            JOptionPane.showMessageDialog(this, IoEx.getMessage(), IoEx.getClass().getSimpleName(),
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        mainPnl = new JPanel(new GridLayout(3, 2, 15, 15));
        mainPnl.setBorder(new EmptyBorder(10, 20, 10, 20));
        btnPnl = new JPanel(new FlowLayout());

        bookNameTxF = new JTextField(10);
        bookISBNTxF = new JTextField(10);
        departmentTxF = new JTextField(10);

        bookNameTxF.setEditable(false);
        bookISBNTxF.setEditable(false);
        departmentTxF.setEditable(false);

        readDataBtn = new JButton("Read Next Entry");
        readDataBtn.addActionListener(this);

        mainPnl.add(new JLabel("Book Name:"));
        mainPnl.add(bookNameTxF);
        mainPnl.add(new JLabel("Book ISBN:"));
        mainPnl.add(bookISBNTxF);
        mainPnl.add(new JLabel("Department:"));
        mainPnl.add(departmentTxF);
        btnPnl.add(readDataBtn);

        this.add(mainPnl, BorderLayout.CENTER);
        this.add(btnPnl, BorderLayout.SOUTH);

        this.setSize(400, 200);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == readDataBtn) {
            bookNameTxF.setText(getData());
            bookISBNTxF.setText(getData());
            departmentTxF.setText(getData());
        }
    }

    private String getData() {
        String temp = "";
        try {
            if (dataIn.available() > 0) {
                temp = dataIn.readUTF();
                System.out.println("Retrived data: " + temp);
            } else {
                System.err.println("End Of File");
                JOptionPane.showMessageDialog(this, "Reached the end of file", "END OF FILE", JOptionPane.INFORMATION_MESSAGE);
                dataIn.close();
                System.exit(0); 
            }
        } catch (Exception ex) {
            System.err.println("Could not read data from file:\n" + ex.toString());
            JOptionPane.showMessageDialog(this, ex.getMessage(), ex.getClass().getSimpleName(), JOptionPane.ERROR_MESSAGE);
        }
        return temp;
    }

    public static void main(String args[]) {
        L6BookReadFile app = new L6BookReadFile();
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}