package collectionsequalshash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistryCourt {

    public static void main(String[] args) {
        List<Company> companies = new ArrayList<>(Arrays.asList(new Company("Fehér Kft.", "123456"),
                new Company("Fekete ZRt.", "234567"),
                new Company("Kék Bt.", "345678"),
                new Company("Piros NyRt.", "567890")));

        Company ceg01 = new Company("Fehér Kft.", "123456");
        Company ceg02 = new Company("Fekete ZRt.", "234567");
        Company ceg03 = new Company("Zöld Bt.", "345678");
        Company ceg04 = new Company("Piros NyRt.", "456789");

        System.out.println(companies.contains(ceg01));
        System.out.println(companies.contains(ceg02));
        System.out.println(companies.contains(ceg03));
        System.out.println(companies.contains(ceg04));
    }
}
