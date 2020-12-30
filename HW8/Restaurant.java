//I worked on the homework assignment alone, using only course materials.
/**.
 * Represents a Restaurant object
 * @author Rahul
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private int numReviews;

    /**.
    * constructor for NotARestaurantException object
    * @param name String holding the name for the restaurant
    * @param reviews int holding the number of reviews for the restaurant
    */
    public Restaurant(String name, int reviews) {
        this.name = name;
        this.numReviews = reviews;
    }

    /**.
    * getter for the name of the restaurant
    * @return the name of restaurant.
    */
    public String getName() {
        return this.name;
    }
    /**.
    * getter for the number of reviews of the restaurant
    * @return the number of reviews of restaurant.
    */
    public int getNumReviews() {
        return this.numReviews;
    }
}