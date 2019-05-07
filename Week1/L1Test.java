/**
 * L1Test
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * 
 * Description:
 * 	This program instanciate Video, GroceryItem and PC Objects using its constructors.
 *  Then the class calls display() function on each object to display their parameters to the console.
 *  Depend on the following classes:
 *      - L1GroceryItem
 *      - L1PC
 *      - L1Video
 */

class L1Test {
    public static void main(String[] args) {
        L1Video vid1 = new L1Video("Java", "John Doe", "Educational", "A", 12.5, true);
        L1GroceryItem prod1 = new L1GroceryItem("carrot", "carrot land", 500, 0.07, 100);
        L1PC pc1 = new L1PC("asus", "L4000", "Intel i5-2500k");

        vid1.display();
        System.out.println();
        prod1.display();
        System.out.println();
        pc1.display();
        System.out.println();
    }
}