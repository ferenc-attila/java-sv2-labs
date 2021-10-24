package objects;

import java.util.Arrays;
import java.util.List;

public class ObjectsInLesson {

    public static void main(String[] args) {

        Trainer t1 = new Trainer("John Doe");

        Trainer t2 = null;

        System.out.println(t1);
        System.out.println(t2);

        if (t2 == null) {
            System.out.println("t2 is null");
        }

        Trainer t3 = new Trainer("John Doe");
        System.out.println(t1 == t3);

        t3 = t1;
        System.out.println(t1 == t3);

        Trainer[] trainers = {t1};

        List<Trainer> trainersList = Arrays.asList(t1);
    }
}
