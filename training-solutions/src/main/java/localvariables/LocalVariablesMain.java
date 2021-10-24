package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {

        boolean b = false;
        System.out.println(b);

        int a = 2;
        System.out.println(a);

        int i = 3;
        int j = 4;
        int k = i;
        System.out.println("i: " + i + "; j: " + j + "; k: " + k + ";");

        String s = "Hello World!";
        String t = s;
        System.out.println("s: " + s + "; t: " + t + ";");

        {
            int x = 0;
            System.out.println("x: " + x + "; a: " + a + ";");
        }

        System.out.println(a);
    }
}
