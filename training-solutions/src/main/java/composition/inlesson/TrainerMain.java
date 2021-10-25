package composition.inlesson;

public class TrainerMain {

    public static void main(String[] args) {

//        Trainer trainer = new Trainer("John Doe");
//
//        trainer.setAddress(new Address("Eger", "Kossuth utca 12"));
//        System.out.println(trainer.getAddress().getCity());

        Trainer trainer = new Trainer("John Doe", new Address("Eger", "Kossuth u. 21"));
        System.out.println(trainer.getAddress().getLine1());
    }
}
