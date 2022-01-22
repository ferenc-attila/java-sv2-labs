package streams;

import java.util.ArrayList;
import java.util.List;

public class Read {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages) {
        return books.stream().filter(book -> book.getNumberOfPages() < maxNumberOfPages)
                .map(Book::getTitle)
                .toList();
    }

    public List<String> listBookTitlesWithGivenAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equals(author))
                .map(Book::getTitle)
                .sorted()
                .toList();
    }

    public List<String> listAuthors() {
        return books.stream()
                .map(Book::getAuthor)
                .distinct()
                .toList();
    }

    public List<Book> getBooks() {
        return List.copyOf(books);
    }
}
