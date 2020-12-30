//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a ScheduledTreatment object with a treatPatientID,
 * and 2 methods.
 * @author Rahul
 * @version 1.0
 */
public class EmergencyTreatment extends Treatment {

    /**
     * Initialies a EmergencyTreatment object with Heal amount.
     *
     * @param heal int holding the amount of heal
     */
    public EmergencyTreatment(int heal) {
        super(heal);
    }

    @Override
    public void performHeal(Patient[] x) {
        Patient leastHealthy = x[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i].getHealth() < leastHealthy.getHealth()) {
                leastHealthy = x[i];
            }
        }
        leastHealthy.increaseHealth(this);
    }
}
