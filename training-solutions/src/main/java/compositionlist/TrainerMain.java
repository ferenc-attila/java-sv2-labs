package compositionlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrainerMain {

    public static void main(String[] args) {

//        Trainer trainer = new Trainer("John Doe");
//        System.out.println(trainer.getAddresses());
//
//        List<Address> addresses = new ArrayList<>(Arrays.asList(
//                new Address("Budapest", "Váci út 43."),
//                new Address("Pécs", "Fő út 15.")
//        ));
//        trainer.setAddresses(addresses);
//
//        System.out.println(trainer.getAddresses().get(0).getCity());
//
//        trainer.getAddresses().add(new Address("Győr", "Folyó utca 1."));
//        System.out.println(trainer.getAddresses().size());

//        Trainer trainer = new Trainer("John Doe");
//        System.out.println(trainer.getAddresses());
//        System.out.println(trainer.getAddresses().size());
//
//        trainer.getAddresses().add(new Address("Budapest", "Váci utca"));
//        System.out.println(trainer.getAddresses().size());
//
//        trainer.addAddress(new Address("Pécs", "Fő út"));
//        System.out.println(trainer.getAddresses().get(0).getCity());
//        System.out.println(trainer.getAddresses().get(1).getCity());

        List<Address> address = new ArrayList<>(Arrays.asList(new Address(
                "Budapest", "Váci utca"),
                new Address("Győr", "Folyó utca")));
        Trainer trainer = new Trainer("John Doe", address);
        System.out.println(trainer.getAddresses().get(1).getCity());

    }
}
