package objects;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {

    public static void main(String[] args) {

        Book emptyBook = null;
        System.out.println(emptyBook);

        if (emptyBook == null) {
            System.out.println("emptyBook is null");
        }

        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);

        Book anotherBook = new Book();
        System.out.println(book == anotherBook);

        anotherBook = book;
        System.out.println(anotherBook);
        System.out.println(book == anotherBook);

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        Book[] arrayOfBooks = new Book[]{book1, book2, book3};
        System.out.println(Arrays.toString(arrayOfBooks));

        List<Book> listOneOfBooks = Arrays.asList(book1, book2, book3);
        System.out.println(listOneOfBooks.toString());

        List<Book> listTwoOfBooks = new ArrayList<>();

        listTwoOfBooks.add(book1);
        listTwoOfBooks.add(book2);
        listTwoOfBooks.add(book3);

        System.out.println(listOneOfBooks.toString());


    }
}
