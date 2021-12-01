package introinheritance.trainer;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void createTest () {
        Trainer trainer = new Trainer();
        Human human = new Human();
        Object object = new Human();
        Human human2 = new Trainer();
        Object object2 = new Trainer();
    }

}