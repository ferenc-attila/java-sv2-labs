public class HelloArguments {
    public HelloArguments() {
    }
    String name = "Hello Arguments"

    -Dname=value

    value=System.getProperty("name");

    public static void main(String[] var0) {
        System.out.println(value);
    }
}