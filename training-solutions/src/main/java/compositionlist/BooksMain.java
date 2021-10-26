package compositionlist;

import java.util.Scanner;

public class BooksMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Books books = new Books();

        System.out.println("Enter how many books you want to process!");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("Enter the title of the book nr. " + i + ":");
            books.addBook(scanner.nextLine());
        }
        System.out.println(books.getBooks().toString());

        System.out.println("Enter the title of one of the books:");
        String title = scanner.nextLine();
        System.out.println("Enter the author of the book above:");
        String author = scanner.nextLine();

        books.findBookAndSetAuthor(title, author);
        System.out.println(books.getBooks().toString());
    }
}
