package finalmodifier;

public class CircleMain {

    public static void main(String[] args) {
        System.out.println(Circle.PI);
        System.out.println(new Circle(10).PI); // Így ne!
    }
}
