package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedicalSurgery {

    private List<Patient> patients;

    public MedicalSurgery(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatientsInTimeOrder() {
        List<Patient> orderedList = new ArrayList<>(patients);
        orderedList.sort(new PatientComparator());
        return orderedList;
    }
}
