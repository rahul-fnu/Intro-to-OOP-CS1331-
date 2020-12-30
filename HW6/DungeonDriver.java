//I worked on the homework assignment alone, using only course materials.
/**
 * A class representing a Cheese Driver.
 * @author Rahul .
 * @version 1
 **/

public class DungeonDriver {
    /**
    * Main method; serves as the driver for our class.
    *
    * @param args String array representing arguments passed by command line
    */
    public static void main(String[] args) {
        Knight galahad = new Knight("Galahad", 6, 7, true);
        Knight lancelot = new Knight("lancelot", 5, 30, false);
        Archer archie = new Archer("Archie", 2, 10);
        Knight ali = new Knight("Galahad", 6, 7, true);
        boolean x = ali.equals(galahad);
        System.out.println(x);
        archie.attack(lancelot);
        galahad.attack(archie);
        archie.attack(galahad);
        lancelot.attack(galahad);
        lancelot.challengeSquire(galahad);
    }
}