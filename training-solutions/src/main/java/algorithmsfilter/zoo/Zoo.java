package algorithmsfilter.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public List<Animal> getAnimalsWithNumberOfLegsGiven(int numberOfLegs) {
        List<Animal> getAnimals = new ArrayList<>();
        for (Animal animal : this.animals) {
            if (animal.getNumberOfLegs() == numberOfLegs) {
                getAnimals.add(animal);
            }
        }
        return getAnimals;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
