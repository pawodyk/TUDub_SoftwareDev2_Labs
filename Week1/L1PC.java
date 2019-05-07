/**
 * L1PC
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * Description:
 * 	This code defines L1PC class
 *  It has one constructor with 3 parameters
 *  It has 3 atributes String @manufacturer, String @model, String @processor.
 *  I has one function display that displays the data to the console. 
 */

public class L1PC {
    private String manufacturer, model, processor;

    L1PC(String manufacturer, String model, String processor){
        this.manufacturer = manufacturer;
        this.model = model;
        this.processor = processor;
    }

    public void display(){
        System.out.println("PC's manufacturer:\t " + manufacturer);
        System.out.println("PC's model:\t " + model);
        System.out.println("PC's processor:\t " + processor);
    }
}