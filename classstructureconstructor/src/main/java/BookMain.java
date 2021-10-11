public class BookMain {

    public static void main(String[] args) {

        Book firstBook = new Book("Shakespeare", "Hamlet");
        Book secondBook = new Book("David Attenborough", "Life on Earth");

        firstBook.register("S1");
        secondBook.register("A1");

        System.out.println("Author: " + firstBook.getAuthor() + "; Title: " + firstBook.getTitle() + "; Reg. number: " + firstBook.getRegNumber());
        System.out.println("Author: " + secondBook.getAuthor() + "; Title: " + secondBook.getTitle() + "; Reg. number: " + secondBook.getRegNumber());

    }
}
