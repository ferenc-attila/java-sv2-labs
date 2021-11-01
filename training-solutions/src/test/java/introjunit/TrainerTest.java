package introjunit;

//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainerTest {

//    @Test
//    public void testCreate() {
//        // Given
//        Trainer trainer = new Trainer("John Doe");
//
//        //When
//        String name = trainer.getName();
//
//        //Then
//        assertThat(name, equalTo("John Doe"));
//    }
//
//    @Test
//    public void testCreate2() {
//        assertThat(new Trainer("John Doe").getName(), equalTo("John Doe"));
//    }
//
//    @Test
//    public void testUppercase() {
//        assertThat(new Trainer("John Doe").getNameUppercase(), equalTo("JOHN DOE"));
//    }

    @Test
    void testCreate() {
        //Given
        Trainer trainer = new Trainer("John Doe");

        //When
        String name = trainer.getName();

        //Then
        assertEquals("John Doe", name);
    }

    @Test
    void testCreate2() {
        assertEquals("John Doe", new Trainer("John Doe").getName());
    }

    @Test
    void testUppercaseName() {
        assertEquals("JOHN DOE", new Trainer("John Doe").getNameUppercase());
    }
}
