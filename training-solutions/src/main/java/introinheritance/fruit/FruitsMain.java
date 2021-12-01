package introinheritance.fruit;

public class FruitsMain {

    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        fruit.setName("pear");
        fruit.setWeight(2.3);

        System.out.println(fruit.getName());
        System.out.println(fruit.getWeight());
        System.out.println();

        Grape grape = new Grape();
        grape.setName("Othello");
        grape.setWeight(3.5);
        grape.setType("painter");

        System.out.println(grape.getName());
        System.out.println(grape.getWeight());
        System.out.println(grape.getType());
        System.out.println();

        Apple apple = new Apple();
        apple.setName("jonagold");
        apple.setWeight(2.1);
        apple.setPieces(15);

        System.out.println(apple.getName());
        System.out.println(apple.getWeight());
        System.out.println(apple.getPieces());
        System.out.println();

        GoldenDelicious goldenDelicious = new GoldenDelicious();
        goldenDelicious.setName("golden");
        goldenDelicious.setWeight(4.6);
        goldenDelicious.setPieces(23);

        System.out.println(goldenDelicious.getName());
        System.out.println(goldenDelicious.getWeight());
        System.out.println(goldenDelicious.getPieces());
        System.out.println(goldenDelicious.getColour().toString());
        System.out.println();

        Starking starking = new Starking();
        starking.setName("starking");
        starking.setWeight(1.4);
        starking.setPieces(5);

        System.out.println(starking.getName());
        System.out.println(starking.getWeight());
        System.out.println(starking.getPieces());
        System.out.println(starking.getColour().toString());
        System.out.println();
    }
}
