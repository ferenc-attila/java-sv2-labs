package lambdastreams.bookstore;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public Integer getNumberOfBooks() {
        return books.stream().reduce(0,
                (a, book) -> a + book.getPieces(),
                Integer::sum);
    }

    public Optional<Book> findNewestBook() {
        return books.stream().max(Comparator.comparing(Book::getYearOfPublish));
    }

    public Integer getTotalValue() {
        return books.stream().reduce(0,
                (i, book) -> i + book.getPrice() * book.getPieces(),
                Integer::sum);
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }
}
