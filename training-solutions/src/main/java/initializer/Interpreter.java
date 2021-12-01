package initializer;

public class Interpreter {

    static {
        System.out.print(4);
    }

    static {
        System.out.print(7);
    }

    private String field;

    {
        System.out.print(2);
    }

    {
        System.out.print(3);
    }

    {
        System.out.print(6);
    }

    public Interpreter() {
        System.out.print(1);
    }

    public Interpreter(String field) {
        System.out.print(5);
    }

    public static void main(String[] args) {
        Interpreter interpreterOne = new Interpreter();
        Interpreter interpreterTwo = new Interpreter("");
    }
}
