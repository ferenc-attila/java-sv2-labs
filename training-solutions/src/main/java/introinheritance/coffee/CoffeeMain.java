package introinheritance.coffee;

public class CoffeeMain {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.setName("Java");
        coffee.setPrice(235);
        System.out.println(coffee.getName());
        System.out.println(coffee.getPrice());

        Cappuccino cappuccino = new Cappuccino();
        cappuccino.setName("Omnia");
        cappuccino.setPrice(125);
        System.out.println(cappuccino.getName());
        System.out.println(cappuccino.getPrice());
    }
}
