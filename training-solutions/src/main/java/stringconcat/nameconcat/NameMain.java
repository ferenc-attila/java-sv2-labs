package stringconcat.nameconcat;

public class NameMain {

    public static void main(String[] args) {

        Name janeDoe = new Name("Doe", "Jennifer", "Jane", Title.MRS);
        Name joeDoe = new Name("Doe", "Bolsanaro", "Joe", Title.MR);
        Name johnDoe = new Name("Doe", "", "John", null);
        Name tothKlara = new Name("Tóth", "Klára", "Izabella", Title.DR);
        Name kovacsGeza = new Name("Kovács", "", "Géza", null);

        System.out.println(janeDoe.concatNameWesternStyle());
        System.out.println(joeDoe.concatNameWesternStyle());
        System.out.println(johnDoe.concatNameWesternStyle());
        System.out.println(tothKlara.concatNameWesternStyle());
        System.out.println(kovacsGeza.concatNameWesternStyle());

        System.out.println(tothKlara.concatNameHungarianStyle());
        System.out.println(kovacsGeza.concatNameHungarianStyle());
        System.out.println(janeDoe.concatNameHungarianStyle());
        System.out.println(johnDoe.concatNameHungarianStyle());
        System.out.println(joeDoe.concatNameHungarianStyle());
    }
}
