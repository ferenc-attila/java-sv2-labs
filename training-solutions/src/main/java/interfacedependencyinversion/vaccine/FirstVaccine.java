package interfacedependencyinversion.vaccine;

import java.util.ArrayList;
import java.util.List;

public class FirstVaccine implements Vaccine{

    private List<Person> vaccinationList = new ArrayList<>();

    @Override
    public List<Person> getVaccinationList() {
        return new ArrayList<>(vaccinationList);
    }

    @Override
    public List<Person> generateVaccinationList(List<Person> registrated) {
        List<Person> vaccination = new ArrayList<>();
        for (Person person : registrated) {
            addPregnants(vaccination, person);
        }
        registrated.removeAll(vaccination);
        addPersonsByAge(registrated, vaccination);
        this.vaccinationList = vaccination;
        return vaccination;
    }

    private void addPersonsByAge(List<Person> registrated, List<Person> vaccinationList) {
        while (!registrated.isEmpty()) {
            Person eldestPerson = getEldestPerson(registrated);
            vaccinationList.add(eldestPerson);
            registrated.remove(eldestPerson);
        }
    }

    private void addPregnants(List<Person> vaccinationList, Person person) {
        if (person.getPregnant().equals(Pregnancy.YES)) {
            vaccinationList.add(person);
        }
    }

    private Person getEldestPerson(List<Person> registrated) {
        Person eldestPerson = registrated.get(0);
        for (Person person : registrated) {
            if (eldestPerson.getAge() < person.getAge()) {
                eldestPerson = person;
            }
        }
        return eldestPerson;
    }
}
