package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> toDoList = new ArrayList<>();
        String enteredValue;
        Path path = Paths.get("src/main/resources/todos.txt");

        System.out.println("\n***Teendők listája***\n");

        do {
            System.out.println("Adj meg egy feladatot, amit el kell végezned!");
            System.out.println("Ha végeztél, az \"x\" megadásával léphetsz ki.");
            enteredValue = scanner.nextLine();
            if (!"x".equals(enteredValue)) {
                toDoList.add(enteredValue);
            }
        } while (!"x".equals(enteredValue));

        try {
            Files.write(path, toDoList);
            System.out.println("A listát a " + path + " fájlban mentettem el.");
        } catch (IOException ioe) {
            System.out.println("Unable to write file!");
            ioe.printStackTrace();
        }
    }
}
