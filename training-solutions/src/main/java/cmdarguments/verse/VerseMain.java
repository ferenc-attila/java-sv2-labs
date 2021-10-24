package cmdarguments.verse;

public class VerseMain {

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}
