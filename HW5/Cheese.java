/**
* A representation of a Cheese.
*
* @author Rahul
* @version 1.0
*/

public class Cheese {
    private String cheeseType;
    private double cheesePrice;
    private boolean sentient;
    private int numTraded = 0;
    private static int totalTraded = 0;

    /**
     * Constructor to create a Cheese.
     *
     * @param price double representing price of Cheese
     * @param type String representing type of cheese
     * @param trade int representing the number of times the Cheese object has been traded
     */
    public Cheese(double price, String type, int trade) {
        this.cheeseType = type;
        this.cheesePrice = price;
        this.numTraded = trade;
        if (numTraded >= 3) {
            this.sentient = true;
        } else {
            this.sentient = false;
        }
        Cheese.totalTraded += numTraded;
    }

    /**
     * Constructor to create a Cheese.
     *
     * @param price double representing price of Cheese
     * @param type String representing type of cheese
     */
    public Cheese(double price, String type) {
        this.cheesePrice = price;
        this.cheeseType = type;
        this.numTraded = 0;
    }

    /**
    * String representation of a Cheese.
    *
    * @return String holding type of cheese and number of times it has been trades
    */
    public String toString() {
        String cheeseString = "";
        if (!this.sentient) {
            cheeseString = "This is a slice of" + this.cheeseType
                + "cheese that has been traded" + this.numTraded + "times.";
        } else {
            cheeseString = "I am a slice of" + this.cheeseType
                + "cheese that has been traded" + this.numTraded + "times.";
        }
        return cheeseString;
    }

    /**
    * Checks if the the cheese object passed into it equal to the current Cheese object.
    * @param other Cheese representing the cheese object being compared to
    * @return boolean showing if the objects are equal or not.
    */
    public boolean isEquals(Cheese other) {
        if (this.cheeseType == null || other.cheeseType == null) {
            return false;
        } else {
            return (this.cheeseType == other.cheeseType
                && this.cheesePrice == other.cheesePrice && this.sentient == other.sentient);
        }
    }

    /**
    * Trades two cheese objects.
    */
    public void isTraded() {
        this.numTraded += 1;
        Cheese.totalTraded += 1;
        if (this.numTraded >= 3 && !this.getSentient()) {
            this.sentient = true;
            this.cheesePrice *= 2;
            System.out.println("I’m ALIIIIIVE!");
        }
    }

    /**
    * Gets the type of cheese.
    *
    * @return String holding type of Cheese
    */
    public String getCheeseType() {
        return this.cheeseType;
    }

    /**
    * Sets the new type of Cheese.
    *
    * @param newType String representing the new type of Cheese.
    */
    public void setCheeseType(String newType) {
        this.cheeseType = newType;
    }

    /**
    * Gets the price of cheese.
    *
    * @return double holding price of Cheese
    */
    public double getCheesePrice() {
        return this.cheesePrice;
    }

    /**
    * Sets the new price of Cheese.
    *
    * @param newPrice double representing the new price of Cheese.
    */
    public void setCheesePrice(double newPrice) {
        this.cheesePrice = newPrice;
    }

    /**
    * Gets the sentient value of cheese.
    *
    * @return boolan holding sentient value of Cheese
    */
    public boolean getSentient() {
        return this.sentient;
    }

    /**
    * Sets the sentient value Cheese.
    *
    * @param newSentient boolean representing the new sentient value of of Cheese.
    */
    public void setSentient(boolean newSentient) {
        this.sentient = newSentient;
    }
}