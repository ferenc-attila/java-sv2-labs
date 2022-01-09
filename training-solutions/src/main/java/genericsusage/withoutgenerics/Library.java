package genericsusage.withoutgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

    public Book getFirstBook(List books) {
        validateListOfBooks(books);
        try {
            return (Book) books.get(0);
        } catch (ClassCastException cce) {
            throw new ClassCastException("Not a book");
        }
    }

    private void validateListOfBooks(List books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        }
        if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
    }
}
