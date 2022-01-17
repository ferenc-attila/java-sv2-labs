package searching;

import java.util.Collections;
import java.util.List;

public class BookSearch {

    private List<Book> books;

    public BookSearch(List<Book> books) {
        this.books = books;
    }

    public Book findBookByAuthorTitle(String author, String title) {
        validateParameters(author, title);
        if (Collections.binarySearch(books, new Book(0, author, title)) < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        } else {
            return books.get(Collections.binarySearch(books, new Book(0, author, title)));
        }
    }

    private void validateParameters(String firstParameter, String secondParameter) {
        if (firstParameter == null || secondParameter == null || firstParameter.isBlank() || secondParameter.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
    }
}
