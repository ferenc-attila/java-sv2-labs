package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        String prefix = "Hello ";
        System.out.println(prefix);

        String name = "John Doe";
        System.out.println(name);

        String message = prefix + name;
        System.out.println(message);

        message = message + 444;
        System.out.println(message);

        boolean b = message.equals("Hello John Doe");
        System.out.println(b);

        boolean c = message.equals("Hello John Doe444");
        System.out.println(c);

        String emptyString = "" + "";
        System.out.println(emptyString);
        System.out.println(emptyString.length());

        String abc = "Abcde";

        System.out.println(abc.length());
        System.out.println(abc.substring(0, 1) + ", " + abc.substring(2, 3));
        System.out.println(abc.substring(0, 3));
    }
}
