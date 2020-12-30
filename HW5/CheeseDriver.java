/**
* A representation of a Cheese Driver.
*
* @author Rahul
* @version 1.0
*/
public class CheeseDriver {
    /**
    * Main method; serves as the driver for our class.
    *
    * @param args String array representing arguments passed by command line
    */
    public static void main(String[] args) {
        Cheese blueCheese = new Cheese(4, "Blue Cheese", 2);
        Cheese cheddarCheese = new Cheese(4, "cheddarCheese", 2);
        Cheese feta = new Cheese(2, "feta", 2);
        Cheese mozzarella = new Cheese(5, "Mozzarella", 2);
        CheeseConnoisseur ali = new CheeseConnoisseur("Ali", feta, 10);
        CheeseConnoisseur aravind = new CheeseConnoisseur("Aravind", blueCheese, 10);
        CheeseConnoisseur sylesh = new CheeseConnoisseur("Sylesh", 20);
        CheeseConnoisseur levi = new CheeseConnoisseur("Levi", feta, 5);
        CheeseConnoisseur a =  new CheeseConnoisseur();
        ali.tradeCheese(aravind);
        sylesh.tradeCheese(ali);
        aravind.tradeCheese(sylesh);
        ali.tradeCheese(levi);
        sylesh.tradeCheese(levi);
        System.out.println(levi.getCheeseOwned());
        System.out.println(aravind.getCheeseOwned());
        levi.tradeCheese(aravind);
        a.tradeCheese(feta);
        System.out.println(blueCheese.getSentient());
    }
}