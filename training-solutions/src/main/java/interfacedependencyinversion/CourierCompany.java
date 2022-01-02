package interfacedependencyinversion;

public class CourierCompany {

    public static void main(String[] args) {
        Box smallBox = new SmallBox();
        Box mediumBox = new MediumBox();
        Box largeBox = new LargeBox();
        Box extraLargeBox = new ExtraLargeBox();

        System.out.println(smallBox.getSize());
        System.out.println(smallBox.getPrice());
        System.out.println(mediumBox.getSize());
        System.out.println(mediumBox.getPrice());
        System.out.println(largeBox.getSize());
        System.out.println(largeBox.getPrice());
        System.out.println(extraLargeBox.getSize());
        System.out.println(extraLargeBox.getPrice());
    }
}
