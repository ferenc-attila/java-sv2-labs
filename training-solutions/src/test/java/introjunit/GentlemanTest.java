package introjunit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GentlemanTest {

    @Test
    public void sayHelloTest() {
        assertThat(new Gentleman().sayHello("John Doe"), equalTo("Hello John Doe!"));
    }

    @Test
    public void sayHelloTestEmptyString() {
        assertThat(new Gentleman().sayHello(""), equalTo("Hello Anonymous!"));
    }
}
