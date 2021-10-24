package cmdarguments.operation;

public class Operation {

    public static void main(String[] args) {

        for (String arg : args) {
            if (arg.equals("/list")) {
                System.out.println("Listázás");
            } else if (arg.equals("/add")) {
                System.out.println("Hozzáadás");
            } else if (arg.equals("/delete")) {
                System.out.println("Törlés");
            } else System.out.println("Ismeretlen művelet");
        }
    }
}



