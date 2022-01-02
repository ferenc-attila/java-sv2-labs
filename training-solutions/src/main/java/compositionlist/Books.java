package compositionlist;

import java.util.ArrayList;
import java.util.List;

public class Books {

    List<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
    }

    public void findBookAndSetAuthor(String title, String author) {
        if (books.contains(title)) {
            books.set(books.indexOf(title), author + ": " + title);
        }
    }

    public List<String> getBooks() {
        return books;
    }
}
