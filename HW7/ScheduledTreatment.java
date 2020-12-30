//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a ScheduledTreatment object with a treatPatientID,
 * and 2 methods.
 * @author Rahul
 * @version 1.0
 */
public class ScheduledTreatment extends Treatment {
    private int treatPatientID;

    /**
     * Initialies a ScheduledTreatment object with the with patientID and Heal amount.
     *
     * @param x int holding the amount of heal
     * @param y int holding the PatientID
     */
    public ScheduledTreatment(int x, int y) {
        super(x);
        this.treatPatientID = y;
    }

    @Override
    public void performHeal(Patient[] x) {
        HealAbility.sortPatients(x);
        int min = 0;
        int max = x.length;
        int mid;
        boolean found = false;
        Patient heal = new Patient("a", Integer.MIN_VALUE, 0);
        Patient other = new Patient("b", Integer.MIN_VALUE, treatPatientID);
        while (!found && min < max) {
            mid = (max + min) / 2;
            if (x[mid].compareTo(other) == 0) {
                heal = x[mid];
                found = true;
                break;
            } else {
                if (x[mid].compareTo(other) > 0) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
        }
        if (found) {
            heal.increaseHealth(this);
        }

    }
}
