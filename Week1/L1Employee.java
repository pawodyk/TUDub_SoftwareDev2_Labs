/**
 * L1Employee
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * Description:
 *      
 * 	This class defines the L1Emplyee
 *  this L1Employee has one constructor
 *      L1Emplyee(String, String, int)
 *  - 3 attributes
 *      String: @name 
 *      String: @address
 *      int:    @salary
 *  - one method
 *      display() - that display each attribute to the console    
 */

public class L1Employee {
    private String name, address;
    private int salary;

    L1Employee(String name, String address, int salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee name:\t " + name);
        System.out.println("Employee address:\t " + address);
        System.out.println("Employee salary:\t " + salary);
    }
}