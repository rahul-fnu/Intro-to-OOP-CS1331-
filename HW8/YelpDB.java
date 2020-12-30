import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
//I worked on the homework assignment alone, using only course materials.
/**.
 * Represents a YekpDB with several static methods
 * @author Rahul
 * @version 1.0
 */

public class YelpDB {
    private static double ratingFinal;
    private static boolean unavailable = true;
    /**
    * Main method; serves as the driver for our class.
    *
    * @param args String array representing arguments passed by command line
    */
    public static void main(String[] args) throws ReviewNotFoundException, NotARestaurantException {
        File open = new
                File("/Users/rahulraiii/Documents/GATech/FirstYear/Spring2020/CS1331/HW08/database_restaurants");
        String[] pathnames = open.list();
        ArrayList<Restaurant> x = load(open);
        double xy = 0;
        try {
            xy = readReview(open, x, args[0], args[1]);
        } catch (NotARestaurantException e) {
            e.getMessage();
        } catch (ReviewNotFoundException e) {
            new ReviewNotFoundException("That is not a review!");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An UnknownError occured");
        }
    }

    /**
    * Load method to add all the restuarant objects into an Array List.
    *
    * @param newFile File containg the file with will have restuarant review folders
    * @return ArrayList containing the restaurant objects in the file.
    */
    public static ArrayList<Restaurant> load(File newFile)  {
        ArrayList<Restaurant> restaurant = new ArrayList<>();
        loadHelper(newFile, restaurant);
        return restaurant;
    }

    /**.
    * loadHelper method to recursively add all the resuarants to the
    *
    * @param newFile File containg the file with will have restuarant review folders,
    * @param restaurant ArrayList containing the ArrayList in which Restaurant objects will be added
    * @return the ArrayList with restaurant objects.
    */
    public static ArrayList<Restaurant> loadHelper(File newFile, ArrayList<Restaurant> restaurant) {
        String x = newFile.getName();
        String y = "";
        String z = "";
        if ((x.length() > 10) && (x.substring(0, 10).equals("restaurant"))) {
            z = x.substring(10, x.length());
            y = newFile.getAbsolutePath();
            String[] newArray = newFile.list();
            int b = newArray.length;
            Restaurant current = new Restaurant(z, b);
            restaurant.add(current);
        } else {
            File[] newArrayTwo = newFile.listFiles();
            for (File xyz : newArrayTwo) {
                try {
                    loadHelper(xyz, restaurant);
                } catch (NullPointerException e) {

                }
            }
        }
        return restaurant;
    }
    /**
    * countNumReviews method to count the number of reviews of a restaurant.
    *
    * @param x holding the Arraylist with the restaurant objects
    * @return int holding the total number of reviews for restaurants in the ArrayList
    */
    public static int countNumReviews(ArrayList<Restaurant> x) {
        int reviews = 0;
        for (int i = 0; i < x.size(); i++) {
            reviews += (x.get(i)).getNumReviews();
        }
        return reviews;
    }

    /**
    * readReview method to read the rating from a given review.
    *
    * @param newFile File containg the file in which a particular review is located
    * @param restaurantList ArrayList containing the ArrayList which contains the resaurants
    * @param restaurantName String holding the name of the resaurant, the review is about
    * @param reviewName String containing the name of the review
    * @return double holding the ratings for a restaurant,
    */
    public static double readReview(File newFile, ArrayList<Restaurant> restaurantList,
        String restaurantName, String reviewName) throws ReviewNotFoundException, NotARestaurantException {
        double rating = 0;
        boolean resExist = false;
        for (Restaurant thereExist : restaurantList) {
            if ((thereExist.getName()).equals(restaurantName)) {
                resExist = true;
            }
        }
        if (resExist) {
            try {
                readReviewHelper(newFile, restaurantName, reviewName);
            } catch (FileNotFoundException e) {
                e = new FileNotFoundException("File not found");
                System.out.println(e.getMessage());
            }
        } else {
            throw new NotARestaurantException();
        }
        return ratingFinal;

    }
    /**
    * readReviewHelper method to read the rating from a given review recursively.
    *
    * @param newFile File containg the file in which a particular review is located

    * @param restaurantName String holding the name of the resaurant, the review is about
    * @param reviewName String containing the name of the review
    */
    public static void readReviewHelper(File newFile,
            String restaurantName, String reviewName)throws ReviewNotFoundException, FileNotFoundException {
        String ab = "restaurant" + restaurantName;
        String bc = newFile.getName();
        double x = 0;
        double y = 0;
        int j = 1;
        if ((bc.length() > 10) && (bc.substring(0, 10).equals("restaurant"))
                && (bc.substring(10, bc.length()).equals(restaurantName))) {
            for (File a : newFile.listFiles()) {
                j += 1;
                if (((a.getName()).substring(6, (a.getName()).length() - 4).equals(reviewName))) {

                    Scanner newScanner = new Scanner(a);
                    ArrayList<String> list = new ArrayList<String>();
                    for (int i = 0; i < 3; i++) {
                        list.add(newScanner.nextLine());
                    }
                    ratingFinal =  Double.parseDouble((list.get(list.size() - 1)).substring(8));
                    unavailable = false;

                } else {
                    continue;
                }

            }
            if (j >= ((newFile.listFiles()).length) && unavailable) {
                throw new ReviewNotFoundException("That is not a review!");
            }
        } else {
            File[] newArrayThree = newFile.listFiles();
            for (File xyz : newArrayThree) {
                try {
                    readReviewHelper(xyz, restaurantName, reviewName);
                } catch (NullPointerException e) {

                }
            }

        }

    }
}

