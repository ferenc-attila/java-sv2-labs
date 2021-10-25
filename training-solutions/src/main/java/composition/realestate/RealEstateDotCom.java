package composition.realestate;

public class RealEstateDotCom {

    public static void main(String[] args) {

        RealEstate niceHouse = new RealEstate("Family house in Eger",
                45.5, new Details("Also suitable for a larger family",
                new Address("Eger", "H3304", "Széchenyi str.", 45),
                150, 2500));

        System.out.println(niceHouse);
        System.out.println(niceHouse.getDetails().toString());
        System.out.println(niceHouse.getDetails().getAddress().toString());

        niceHouse.setTitle("Downtown apartment");
        niceHouse.setPrice(28.7);
        niceHouse.getDetails().getAddress().setCity("Győr");
        niceHouse.getDetails().getAddress().setZipCode("H8800");
        niceHouse.getDetails().getAddress().setStreet("Fő utca");
        niceHouse.getDetails().getAddress().setHouseNumber(7);
        niceHouse.getDetails().setDescription("Small, but well equipped");
        niceHouse.getDetails().setSquareMeter(50);
        niceHouse.getDetails().setAreaOfSite(0);

        System.out.println(niceHouse);
        System.out.println(niceHouse.getDetails().toString());
        System.out.println(niceHouse.getDetails().getAddress().toString());

        System.out.println(niceHouse.getTitle());
        System.out.println(niceHouse.getPrice());
        System.out.println(niceHouse.getDetails().getDescription());
        System.out.println(niceHouse.getDetails().getSquareMeter());
        System.out.println(niceHouse.getDetails().getAreaOfSite());
        System.out.println(niceHouse.getDetails().getAddress().getZipCode());
        System.out.println(niceHouse.getDetails().getAddress().getCity());
        System.out.println(niceHouse.getDetails().getAddress().getStreet());
        System.out.println(niceHouse.getDetails().getAddress().getHouseNumber());
    }
}
