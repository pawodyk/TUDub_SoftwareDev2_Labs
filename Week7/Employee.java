/**
 * Employee
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  04/03/19
 * Description:
 *      Class hold the information regarding the Employee
 *      Class is initialized when Employee is created and can be read using standard public getter functions
 * 
 * 	    Class used by L7EmployeeWriteFile, L7EmployeeReadFile, EmployeeDatabase
 */

public class Employee {
    private int empID;
    private String empFname, empLname;
    private double empPay;

    Employee(int id, String fname, String lname, double pay) {
        empID = id;
        empFname = fname;
        empLname = lname;
        empPay = pay;
    }

    public String toString() {
        return "Employee number: " + empID + "[" + empFname + ", " + empLname + ", " + empPay + "]";
    }

    /**
     * @return the employee ID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * @return the employee first name
     */
    public String getEmpFname() {
        return empFname;
    }

    /**
     * @return the employee last name
     */
    public String getEmpLname() {
        return empLname;
    }

    /**
     * @return the employee weekly pay
     */
    public double getEmpPay() {
        return empPay;
    }

}