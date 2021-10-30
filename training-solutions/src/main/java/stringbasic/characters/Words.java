package stringbasic.characters;

import java.util.Scanner;

public class Words {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WordsStudent student = new WordsStudent();

        System.out.println("****** Learn to type ******\n");
        System.out.println("**** Teacher's console ****\n");
        System.out.println("Enter a word:");
        String word = scanner.nextLine();

        WordsTeacher teacher = new WordsTeacher(word);

        System.out.println("**** Student's console ****\n");
        System.out.println("You have to type the word below:\n");
        System.out.println(teacher.getWord());

        for (int i = 0; i < teacher.getWordLength(); i++) {
            System.out.println("Enter only one character:");
            String c = scanner.nextLine();
            student.addCharacter(c);
        }

        System.out.println("**** Rating ****\n");

        System.out.println("You entered the stringbasic.characters below:");
        for (String character : student.getCharacters()) {
            System.out.println(character);
        }
        System.out.println("\nThe word you typed was:\n");
        System.out.println(student.getEnteredWord());
        if (student.getEnteredWord().equals(teacher.getWord())) {
            System.out.println("\n\nCongratulation, you typed correctly!");
        } else {
            System.out.println("\n\nSorry! You still have to practice!");
        }
    }
}
