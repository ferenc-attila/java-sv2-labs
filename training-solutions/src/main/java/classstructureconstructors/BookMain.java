package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("David Attenborough", "Life On Earth");

        book.register("123456789");

        System.out.println("Author: " + book.getAuthor());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Registration number: " + book.getRegNumber());

    }

}
