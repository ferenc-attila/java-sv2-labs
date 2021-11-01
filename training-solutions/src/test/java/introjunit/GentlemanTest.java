package introjunit;

//import org.junit.Test;
//
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GentlemanTest {

//    @Test
//    public void sayHelloTest() {
//        assertThat(new Gentleman().sayHello("John Doe"), equalTo("Hello John Doe!"));
//    }
//
//    @Test
//    public void sayHelloTestEmptyString() {
//        assertThat(new Gentleman().sayHello(""), equalTo("Hello Anonymous!"));
//    }

    @Test
    void sayHelloTest() {
        assertEquals("Hello John Doe!", new Gentleman().sayHello("John Doe"));
    }

    @Test
    void sayHelloTestEmptyString() {
        assertEquals("Hello Anonymous!", new Gentleman().sayHello(""));
    }
}
