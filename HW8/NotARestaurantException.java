//I worked on the homework assignment alone, using only course materials.
/**.
 * Represents a NotARestaurantException class
 * @author Rahul
 * @version 1.0
 */
public class NotARestaurantException extends RuntimeException {
    /**.
    * constructor for NotARestaurantException object
    */
    public NotARestaurantException() {
        System.out.println("That is not a restaurant we know!");
    }
}