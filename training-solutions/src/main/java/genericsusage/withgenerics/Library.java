package genericsusage.withgenerics;

import java.util.List;

import genericsusage.Book;

public class Library {

    public Book getFirstBook(List<Book> books) {
        validateListOfBooks(books);
        return books.get(0);
    }

    private void validateListOfBooks(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
    }
}
