package interfacedependencyinversion.vaccine;

import java.util.List;

public interface Vaccine {

    List<Person> getVaccinationList();
    List<Person> generateVaccinationList(List<Person> registrated);
}
