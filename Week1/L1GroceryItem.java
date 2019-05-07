/**
 * L1GroceryItem
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * Description:
 * 	This code defines L1GroceryItem class
 *  It has one constructor with 5 parameters
 *  It has 5 atributes String @name, String @supplier, int @stockLevel, double @price, int reOrderLevel.
 *  I has one function display that displays the data to the console. 
 */

public class L1GroceryItem {
    private String name, supplier;
    private int stockLevel, reOrderLevel;
    private double price;

    L1GroceryItem(String name,
                String supplier, 
                int stockLevel,
                double price,
                int reOrderLevel){
        this.name = name;
        this.supplier = supplier;
        this.stockLevel = stockLevel;
        this.price = price;
        this.reOrderLevel = reOrderLevel;
    }

    public void display(){
        System.out.println("Grocery Item's name is:\t" + name);
        System.out.println(name + "'s supplier is:\t" + supplier);
        System.out.println(name + "'s Level of Stock is:\t" + stockLevel);
        System.out.println(name + "'s price is:\t" + price);
        System.out.println(name + "'s Reorder Level:\t" + reOrderLevel);
    }
}