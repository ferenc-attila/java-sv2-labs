package interfaces.animal;

import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public int getNumberOfAllLegs() {
        int result = 0;
        for (Animal actual : animals) {
            result += actual.getNumberOfLegs();
        }
        return result;
    }
}
