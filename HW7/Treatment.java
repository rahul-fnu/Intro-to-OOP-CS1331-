//I worked on the homework assignment alone, using only course materials.
/**
 * Represents the abstract Treatment class which implements HealAbility interface
 * and 4 methods.
 * @author Rahul
 * @version 1.0
 */
public abstract class Treatment implements HealAbility {
    private int heal;

    /**
     * Initializes a Treatment object with a parameter list corresponding
     * to all of its fields.
     * @param  x int holding the amount of heal.
     */
    public Treatment(int x) {
        this.heal = x;
    }

    /**
     * method to return the amount of heal.
     * @return the value of heal,
     */
    public int getHealAmount() {
        return this.getHeal();
    }
    @Override
    public String toString() {
        return "Treatment with " + this.getHeal() + " heal";
    }
    /**
     * getter for heal.
     * @return the value of heal
     */
    public int getHeal() {
        return this.heal;
    }

    /**
     * setter for patientID.
     * @param x the value of new heal
     */
    public void setHeal(int x) {
        this.heal = x;
    }
}
