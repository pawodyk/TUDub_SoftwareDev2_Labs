import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * L7EmployeeWriteFile
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  04/03/19
 * Description:
 * 	    Create a program that creates a random access file that might be used in a HR department.
 *      This program should store the following details to a file:
 *          - Employeed ID
 *          - Firstname
 *          - Lastname
 *          - Weekly Pay
 *      Use the Frame object, pushbuttons and try and catch to assist with your solution.
 * 
 *      Use Class EmployeeDatabase and Employee
 */

public class L7EmployeeWriteFile extends JFrame implements ActionListener {

    JPanel mainPnl;
    JButton addBtn, exitBtn;
    JTextField idTxtFd, fnameTxtFd, lnameTxtFd, payTxtFd;

    EmployeeDatabase empdb;

    public L7EmployeeWriteFile() {
        super("Employee Database - Add Employee data");

        try {
            empdb = new EmployeeDatabase();
            empdb.wipeFile();
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

        addBtn = new JButton("Add Employee");
        exitBtn = new JButton("Save and Exit");

        addBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        mainPnl.add(new JLabel("Employee ID"));
        mainPnl.add(idTxtFd);

        mainPnl.add(new JLabel("Firstname"));
        mainPnl.add(fnameTxtFd);

        mainPnl.add(new JLabel("Lastname"));
        mainPnl.add(lnameTxtFd);

        mainPnl.add(new JLabel("Weekly Pay"));
        mainPnl.add(payTxtFd);

        mainPnl.add(addBtn);
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            try {
                int id = Integer.parseInt(idTxtFd.getText());
                if (id > 0 && id <= (empdb.getFileSize() / empdb.getRecordSize())) {
                    submitData();
                } else {
                    throw new Exception("Incorrect ID");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPnl, "Please enter correct user ID in the field provided",
                        "Incorrect ID", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == exitBtn) {
            empdb.closeConnection();
            System.exit(0);
        }

    }

    private void submitData() {
        int empId = 0, result = 0;
        String fname = "", lname = "";
        double pay = 0.0;

        try {
            empId = Integer.parseInt(idTxtFd.getText());
            fname = fnameTxtFd.getText();
            lname = lnameTxtFd.getText();
            pay = Double.parseDouble(payTxtFd.getText());
            Employee emp = new Employee(empId, fname, lname, pay);
            System.out.println(emp.toString());
            result = empdb.writeToFile(emp);
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        } finally {
            if (result == 1) {
                JOptionPane.showMessageDialog(mainPnl, "Employee added sucessfully", "Sucess!",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainPnl, "Employee could not be added", "Failed!",
                        JOptionPane.WARNING_MESSAGE);
            }
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
        new L7EmployeeWriteFile();
    }
}

// class WriteEmployee {

//     private int empID; // 4 bytes per int
//     private String empFname, empLname; // 2bytes per char => 10 + 10 bytes
//     private double empPay; // 8 bytes per double
//     private final int size = 32;
//     private final int numOfEmp = 3;
//     private final int strLg = 5;

//     RandomAccessFile raf;

//     public WriteEmployee() {
//         File file = new File("database\\employee.dat");

//         try {
//             raf = new RandomAccessFile(file, "rw");
//             raf.setLength(size * numOfEmp);

//             System.out.println(raf.length());
//         } catch (Exception e) {
//             System.err.println("error1 -> " + e.toString());
//         }
//     }

//     public void addEmp(int id, String fname, String lname, double empPay) {
//         try {

//             // handleString(fname);
//             // handleString(lname);
//             raf.seek((id - 1) * size);
//             raf.writeInt(id);
//             raf.writeChars(fname);
//             raf.writeChars(lname);

//         } catch (Exception e) {
//             System.err.println("error2 -> " + e.toString());
//         }
//     }

//     private void handleString(String str) {
//         try {
//             char[] temp = new char[5];
//             temp = str.toCharArray();
//             System.out.println(str + " => " + new String(temp));

//         } catch (Exception e) {
//             System.err.println("error2.1 -> " + e.toString());
//         }
//     }

//     public void getEmp(int position) {
//         try {
//             //System.out.println(RanAcc.length());
//             System.out.println("\n" + position + ":");
//             raf.seek((position - 1) * size);

//             System.out.println(raf.readInt());

//             char[] charArr1 = new char[strLg];
//             for (int i = 0; i < charArr1.length; i++) {
//                 charArr1[i] = raf.readChar();
//             }
//             System.out.println(new String(charArr1));

//             char[] charArr2 = new char[strLg];
//             for (int i = 0; i < charArr2.length; i++) {
//                 charArr2[i] = raf.readChar();
//             }
//             System.out.println(new String(charArr2));

//         } catch (Exception e) {
//             System.err.println("error3 -> " + e.toString());
//         }

//     }

//     public void zero() {
//         try {
//             raf.seek(0);
//         } catch (Exception e) {
//             System.err.println("error4 -> " + e.toString());
//         }
//     }

// }