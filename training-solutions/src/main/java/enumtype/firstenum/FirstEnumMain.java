package enumtype.firstenum;

import java.util.Arrays;

public class FirstEnumMain {

    public static void main(String[] args) {

        System.out.println(Continent.EUROPE);
        System.out.println(Continent.ASIA);
        System.out.println(Continent.AFRICA);
        System.out.println(Continent.NORTHAMERICA);
        System.out.println(Continent.SOUTHAMERICA);
        System.out.println(Continent.AUSTRALIA);
        System.out.println(Continent.ANTARCTICA);

        System.out.println(Arrays.toString(Continent.values()));
        for (Continent c : Continent.values()) {
            System.out.println(c);
        }

        System.out.println(Ocean.valueOf("PACIFICOCEAN"));
        System.out.println(Ocean.valueOf("ATLANTICOCEAN"));
        System.out.println(Ocean.valueOf("INDIANOCEAN"));

        System.out.println(Football.BALSZELSO.name());
        System.out.println(Football.JOBBSZELSO.name());
        System.out.println(Football.HATVED.name());
        System.out.println(Football.CSATAR.name());
        System.out.println(Football.KAPUS.name());
        System.out.println(Football.KOZEPPALYAS.name());
    }
}
