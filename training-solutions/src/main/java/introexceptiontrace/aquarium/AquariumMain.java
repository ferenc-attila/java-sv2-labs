package introexceptiontrace.aquarium;

public class AquariumMain {

    public static void main(String[] args) {

        Aquarium aquarium = new Aquarium();

        aquarium.addFish(new Fish("carnivorous", "grey"));
        aquarium.addFish(new Fish("carnivorous", "black"));
        aquarium.addFish(new Fish("phytophagous", "grey"));
        aquarium.addFish(new Fish("phytophagous", "orange"));

        System.out.println(aquarium.getNumberOfFish());

    }
}
