package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class SecondVaccine implements Vaccine {

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return new ArrayList<>(vaccinationList);
    }

    @Override
    public List<Person> generateVaccinationList(List<Person> registrated) {
        List<Person> youngsters = new ArrayList<>();
        List<Person> elders = new ArrayList<>();
        for (Person person : registrated) {
            if (person.getAge() <= 65 && canVaccinated(person)) {
                youngsters.add(person);
            } else if (person.getAge() > 65 && canVaccinated(person)){
                elders.add(person);
            }
        }
        vaccinationList.addAll(youngsters);
        vaccinationList.addAll(elders);
        return new ArrayList<>(vaccinationList);
    }

    private boolean canVaccinated (Person person) {
        return person.getChronic().equals(ChronicDisease.NO) && person.getPregnant().equals(Pregnancy.NO);
    }
}
