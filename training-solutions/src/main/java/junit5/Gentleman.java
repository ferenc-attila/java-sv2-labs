package junit5;

public class Gentleman {

    public String sayHello(String name) {
        if ("".equals(name)) {
            return "Hello Anonymous!";
        }
        return "Hello " + name + "!";
    }
}
