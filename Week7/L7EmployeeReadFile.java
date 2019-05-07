import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;

/**
 * L7EmployeeReadFile
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  04/03/19
 * Description:
 * 	    Once you have created the program to store the Employee details to a file (L7EmployeeWriteFile.java),
 *       the next step is to create a program that can read the details from the file. 
 *      In this program the following details should be displayed:
 *          - Employeed ID
 *          - Firstname
 *          - Lastname
 *          - Weekly Pay
 *      Use the Frame object, pushbuttons and try and catch to assist with your solution.
 * 
 *      Use Class EmployeeDatabase and Employee
 */

public class L7EmployeeReadFile extends JFrame implements ActionListener {

    JPanel mainPnl;
    JButton findBtn, exitBtn;
    JTextField idTxtFd, fnameTxtFd, lnameTxtFd, payTxtFd;

    EmployeeDatabase empdb;

    public L7EmployeeReadFile() {
        super("Employee Database - Read Employee data");

        try {
            empdb = new EmployeeDatabase();
            //throw new IOException("Test Exception");
        } catch (Exception ex) {
            System.err.println(ex.toString());
            JOptionPane.showMessageDialog(mainPnl, "Could not Initialize file because:\n" + ex.toString(), "CRITICAL ERROR!", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        this.inicializeGUI();
    }

    private void inicializeGUI() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 25));

        mainPnl = new JPanel(new GridLayout(5, 2, 10, 10));

        idTxtFd = new JTextField(20);
        fnameTxtFd = new JTextField(20);
        lnameTxtFd = new JTextField(20);
        payTxtFd = new JTextField(20);

        findBtn = new JButton("Get Employee");
        exitBtn = new JButton("Exit");

        idTxtFd.setEditable(true);
        fnameTxtFd.setEditable(false);
        lnameTxtFd.setEditable(false);
        payTxtFd.setEditable(false);

        findBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        mainPnl.add(new JLabel("Employee ID"));
        mainPnl.add(idTxtFd);

        mainPnl.add(new JLabel("Firstname"));
        mainPnl.add(fnameTxtFd);

        mainPnl.add(new JLabel("Lastname"));
        mainPnl.add(lnameTxtFd);

        mainPnl.add(new JLabel("Weekly Pay"));
        mainPnl.add(payTxtFd);

        mainPnl.add(findBtn);
        mainPnl.add(exitBtn);

        this.add(mainPnl);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(mainPnl, "Good Bye");
                System.exit(0);
            }
        });

        //this.setResizable(false);
        this.setSize(600, 300);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() == findBtn) {
            try {
                int id = Integer.parseInt(idTxtFd.getText());
                if (id > 0 && id <= (empdb.getFileSize() / empdb.getRecordSize())) {
                    retriveData(id);
                } else {
                    clearFields();
                    throw new Exception("Incorrect ID");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPnl, "Please enter correct user ID in the field provided",
                        "Incorrect ID", JOptionPane.WARNING_MESSAGE);
            }

        }

        if (ev.getSource() == exitBtn) {
            empdb.closeConnection();
            System.exit(0);
        }
    }

    private void retriveData(int id) {
        Employee emp = empdb.readFromFile(id);
        System.out.println(emp.toString());
        if (emp.getEmpID() != 0) {
            idTxtFd.setText(Integer.toString(emp.getEmpID()));
            fnameTxtFd.setText(emp.getEmpFname());
            lnameTxtFd.setText(emp.getEmpLname());
            payTxtFd.setText(Double.toString(emp.getEmpPay()));
        } else {
            clearFields();
        }

    }

    private void clearFields() {
        idTxtFd.setText("");
        fnameTxtFd.setText("");
        lnameTxtFd.setText("");
        payTxtFd.setText("");

    }

    public static void main(String args[]) {
        new L7EmployeeReadFile();
    }
}