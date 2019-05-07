/**
 * L1Video
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * Description:
 * 	This code defines L1Video class
 *  It has one constructor with 6 parameters
 *  It has 6 atributes Strings @name @director @category @rating, double: @price, and boolean @borrowed.
 *  I has one function display that displays the data to the console. 
 */

public class L1Video {
    private String name, director, category, rating;
    private double price;
    private boolean borrowed;

    L1Video(String name,
                String director, 
                String category,
                String rating,
                double price,
                boolean borrowed){
        this.name = name;
        this.director = director;
        this.category = category;
        this.rating = rating;
        this.price = price;
        this.borrowed = borrowed;
    }

    public void display() {
        System.out.println("the Video name is:\t" + name);
        System.out.println("the Video director is:\t" + director);
        System.out.println("the Video category is:\t" + category);
        System.out.println("the Video rating is:\t" + rating);
        System.out.println("the Video price is:\t" + price);
        System.out.println("is Video borrowed:\t" + borrowed);
    }
}