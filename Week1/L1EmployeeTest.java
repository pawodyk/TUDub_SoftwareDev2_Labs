/**
 * L1EmployeeTest
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * 
 * Description:
 * 	This program instanciate L1Employee object using its constructor with parameters "John Doe", "Dublin, Ireland", 50000
 *  Then the class calls display() function to display L1Employee parameters to the screen.
 *  Depend on the class L1Employee
 */

class L1EmployeeTest {
    public static void main(String[] args) {
        L1Employee emp1 = new L1Employee("John Doe", "Dublin, Ireland", 50000);

        emp1.display();
    }
}