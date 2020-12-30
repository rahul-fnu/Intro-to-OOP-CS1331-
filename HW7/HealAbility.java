//I worked on the homework assignment alone, using only course materials.
/**
 * Represents a Healability with 2 abstract methods,
 * and 1 static method.
 * @author Rahul
 * @version 1.0
 */
public interface HealAbility {

    /**.
     * abstract method to heal patients
     * @param x Patient[] holding the array of patients that need Treatment
     **/
    void performHeal(Patient[] x);

    /**
     * getter for the amount of heal.
     * @return int the amount of heal/
     **/
    int getHealAmount();

    /**
     * static method to sort the patients by their PatientID.
     * @param patientlist Patient[] holding the array of patients being sorted
     **/
    static void sortPatients(Patient[] patientlist) {
        for (int i = 1; i < patientlist.length; i++) {
            int j = i;
            while (j > 0 && patientlist[j - 1].compareTo(patientlist[j]) > 0) {
                Patient temp = patientlist[j];
                patientlist[j] = patientlist[j - 1];
                patientlist[j - 1] = temp;
                j--;
            }
        }
    }
}
