//I worked on the homework assignment alone, using only course materials.
/**
 * A class representing an Archer.
 * @author Rahul .
 * @version 1
 **/
public class Archer extends Adventurer {
    protected int arrows;
    /**
     * A constructor for the adventurer class.
     * @param attackValue double to set the attackValue to
     * @param name String to set name equal to
     * @param healthValue double to set health equal to
     **/
    public Archer(String name, double attackValue, double healthValue) {
        super(name, attackValue, healthValue);
        this.arrows = 10;
    }

    /**
     * A constructor for the adventurer class.
     * @param name String to set name equal to
     **/
    public Archer(String name) {
        super(name, 40, 75);
        this.arrows = 10;
    }

    @Override
    public void attack(Adventurer o) {
        if (!(o == null)) {
            if ((this.getArrows() > 0) && (this.getHealth() > 0)) {
                double damage = this.getAttackPower();
                if ((o.getHealth() - damage) < 0) {
                    o.setHealth(0);
                } else {
                    o.setHealth(o.health - damage);
                }
                this.setArrows(this.getArrows() - 1);
            }
        }
    }
    @Override
    public boolean equals(Object o) {
        Archer x;
        if (o instanceof Archer) {
            x = (Archer) o;
            boolean finalBool = super.equals(x);
            return finalBool;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String x = super.toString();
        return x + ", Arrows: " + this.getArrows();
    }

    /**
     * getter for the arrows.
     * @return int holding the value of arrows
     **/
    public int getArrows() {
        return this.arrows;
    }

    /**
     * setter for the health.
     * @param x double holding the value of arrows
     **/
    public void setArrows(int x) {
        this.arrows = x;
    }
}
