package introjunit;

public class Gentleman {

    public String sayHello(String name) {
        if (name.isEmpty() == true) {
            return "Hello Anonymous!";
        }
        return "Hello " + name + "!";
    }
}
