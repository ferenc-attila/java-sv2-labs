package junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GentlemanTest {

    Gentleman gentleman = new Gentleman();

    @Test
    void sayHelloTest() {
        assertEquals("Hello John Doe!", gentleman.sayHello("John Doe"));
    }

    @Test
    void sayHelloTestEmptyString() {
        assertEquals("Hello Anonymous!", gentleman.sayHello(""));
    }
}

