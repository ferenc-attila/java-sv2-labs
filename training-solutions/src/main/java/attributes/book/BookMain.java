package attributes.book;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Birds of Britain and Europe");
        System.out.println(book);
        System.out.println(book.getTitle());

        book.setTitle("Lord of the Rings");
        System.out.println(book.getTitle());
    }
}
