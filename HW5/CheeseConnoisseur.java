/**
* A representation of a Cheese Connoisseur.
*
* @author Rahul
* @version 1.0
*/

public class CheeseConnoisseur {
    private String nameConnoisseur;
    private Cheese cheeseOwned;
    private double netWorth;

    /**
     * Constructor to create a Cheese Connoisseur.
     *
     * @param name String representing name of the Cheese Connoisseur
     * @param owned Cheese representing type of cheese owned by the Cheese Connoisseur
     * @param money double representing the net worth of Cheese Connoisseur
     */
    public CheeseConnoisseur(String name, Cheese owned, double money) {
        this.nameConnoisseur =  name;
        this.cheeseOwned = owned;
        this.netWorth = money;
    }

    /**
     * Constructor to create a Cheese Connoisseur.
     *
     * @param name String representing name of the Cheese Connoisseur
     * @param money double representing the net worth of Cheese Connoisseur
     */
    public CheeseConnoisseur(String name, double money) {
        this(name, null, money);
    }

    /**
     * Constructor to create a Cheese Connoisseur.
     *
     * @param name String representing name of the Cheese Connoisseur
     */
    public CheeseConnoisseur(String name) {
        this(name, null, 0);
    }

    /**
     * Constructor to create a Cheese Connoisseur.
     *
     */
    public CheeseConnoisseur() {
        this("Louis Pasteur", null, 20);
    }

    /**
    * This method allows the Cheese Connoisseur to replace its current cheese object with the one passed into it.
    *
    * @param newCheese Cheese representing the cheese object Cheese Connoisseur is exchanging with.
    */
    public void tradeCheese(Cheese newCheese) {
        if (!(newCheese == null || this.cheeseOwned == null)) {
            Cheese newOne = this.cheeseOwned;
            this.cheeseOwned = newCheese;
            newCheese = newOne;
            newCheese.isTraded();
            this.cheeseOwned.isTraded();
        }
    }

    /**
    * This method allows the Cheese Connoisseur to trade cheese object with another Cheese Connoisseur passed into it.
    *
    * @param newConnoisseur CheeseConnoisseur representing the Cheese Connoisseur object
        the current Cheese Connoisseur is trading with.
    */
    public void tradeCheese(CheeseConnoisseur newConnoisseur) {
        if (!(newConnoisseur.cheeseOwned == null || this.cheeseOwned == null)) {
            Cheese newOne = newConnoisseur.cheeseOwned;
            Cheese currentOne = this.cheeseOwned;
            if (!newOne.isEquals(this.cheeseOwned)) {
                double currentValue = (this.cheeseOwned).getCheesePrice();
                double newValue = newOne.getCheesePrice();
                double difference = Math.abs(newValue - currentValue);
                if ((currentValue > newValue) && (this.netWorth >= difference)) {
                    this.setCheeseOwned(newOne);
                    newConnoisseur.setCheeseOwned(currentOne);
                    newConnoisseur.netWorth -= difference;
                    newOne.isTraded();
                    currentOne.isTraded();
                } else if ((currentValue < newValue) && (newConnoisseur.netWorth >= difference)) {
                    this.setCheeseOwned(newOne);
                    newConnoisseur.setCheeseOwned(currentOne);
                    this.netWorth -= difference;
                    newOne.isTraded();
                    currentOne.isTraded();
                }
            }
        }
    }

    /**
    * Gets the name of Cheese Connoisseur.
    *
    * @return String holding name of Cheese Connoisseur
    */
    public String getNameConnoisseur() {
        return this.nameConnoisseur;
    }

    /**
    * Sets the name of Cheese Connoisseur.
    *
    * @param newName String representing the new name of Cheese Connoisseur
    */
    public void setNameConnoisseur(String newName) {
        this.nameConnoisseur = newName;
    }

    /**
    * Gets the type of cheese owned by Cheese Connoisseur.
    *
    * @return Cheese holding cheese object owned by Cheese Connoisseur
    */
    public Cheese getCheeseOwned() {
        return this.cheeseOwned;
    }

    /**
    * Sets the cheese object owned by Cheese Connoisseur.
    *
    * @param newCheese Cheese representing the new cheese owned by Cheese Connoisseur
    */
    public void setCheeseOwned(Cheese newCheese) {
        this.cheeseOwned = newCheese;
    }

    /**
    * Gets the net worth of Cheese Connoisseur.
    *
    * @return double holding net worth of Cheese Connoisseur
    */
    public double getNetWorth() {
        return this.netWorth;
    }

    /**
    * Sets the new net worth of Cheese Connoisseur.
    *
    * @param newNetWorth double representing the new net worth of Cheese Connoisseur
    */
    public void setNetWorth(double newNetWorth) {
        this.netWorth = newNetWorth;
    }
}

