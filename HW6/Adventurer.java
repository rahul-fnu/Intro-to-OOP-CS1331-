//I worked on the homework assignment alone, using only course materials.
/**
 * A class representing an Adventurer.
 * @author Rahul .
 * @version 1
 **/

public abstract class Adventurer {
    private String name;
    protected final double attackPower;
    protected double health;

    /**
     * A constructor for the adventurer class.
     * @param attackValue double to set the attackValue to
     * @param name String to set name equal to
     * @param healthValue double to set health equal to
     **/
    public Adventurer(String name, double attackValue, double healthValue) {
        this.name = name;
        this.attackPower = attackValue;
        this.health = healthValue;
    }

    /**
    * A method to attack another adventurer.
    * @param x Adventurer represents another adventurer being attacked
    **/
    public abstract void attack(Adventurer x);

    /**
    * A method to increase health by driniking a health potion.
    **/

    public void drinkHealthPotion() {
        this.health += 15;
    }

    @Override
    public boolean equals(Object o) {
        Adventurer x;
        if (o instanceof Adventurer) {
            x = (Adventurer) o;
            return ((this.name).equals(x.name) && (this.attackPower == x.attackPower) && (this.health == x.health));
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Health: "
            + this.health + ", Attack: " + this.attackPower;
    }

    /**
     * getter for the AttackValue.
     * @return double holding the value of health
     **/
    public double getAttackPower() {
        return this.attackPower;
    }

    /**
     * getter for the health.
     * @return double holding the value of health
     **/
    public double getHealth() {
        return this.health;
    }

    /**
     * setter for the health.
     * @param x double holding the value of new health
     **/
    public void setHealth(double x) {
        this.health = x;
    }

}