//I worked on the homework assignment alone, using only course materials.
/**
 * A class representing an Knight.
 * @author Rahul .
 * @version 1
 **/
public class Knight extends Adventurer {
    protected boolean squire;
    /**
     * A constructor for the knight class.
     * @param attackValue double to set the attackValue to
     * @param name String to set name equal to
     * @param healthValue double to set health equal to
     * @param squireExistence boolean to set the squire to
     **/
    public Knight(String name, double attackValue, double healthValue, boolean squireExistence) {
        super(name, attackValue, healthValue);
        this.squire = squireExistence;
    }

    /**
     * A constructor for the knight class.
     * @param name String to set name equal to
     **/
    public Knight(String name) {
        super(name, 15, 100);
        this.squire = true;
    }

    @Override
    public void attack(Adventurer o) {
        if (!(o == null)) {
            if (this.health > 0) {
                if (this.squire) {
                    double damage = 2 * this.attackPower;
                    if ((o.getHealth() - damage) < 0) {
                        o.setHealth(0);
                    } else {
                        o.setHealth(this.health - damage);
                    }
                } else {
                    double damage = this.attackPower;
                    if ((o.getHealth() - damage) < 0) {
                        o.setHealth(0);
                    } else {
                        o.setHealth(o.getHealth() - damage);
                    }
                }
            }
        }
    }

    /**
    * Challenges the other adventurer for their squire.
    * @param otherKnight Kninght represents the other knight being challenged
    **/
    public void challengeSquire(Knight otherKnight) {
        if (otherKnight != null) {
            double current = this.getHealth();
            boolean currentStatus = this.squire;
            boolean otherStatus = otherKnight.squire;
            if ((current > 0) && (!currentStatus) && (otherStatus)) {
                this.attack(otherKnight);
                if (otherKnight.getHealth() > 0) {
                    otherKnight.attack(this);
                } else {
                    this.squire = true;
                    otherKnight.squire = false;
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        Knight x;
        if (o instanceof Knight) {
            x = (Knight) o;
            boolean finalBool = super.equals(x);
            return finalBool && this.getSquire() == x.getSquire();
        }  else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Squire: " + this.getSquire();
    }

    /**
     * getter for the squire.
     * @return boolean holding the value of squire existence
     **/
    public boolean getSquire() {
        return this.squire;
    }

    /**
     * setter for squire.
     * @param x the value to set it to
     **/
    public void setSquire(Boolean x) {
        this.squire = x;
    }


}