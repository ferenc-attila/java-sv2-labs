package dynamictypes.school;

public class SchoolMain {

    public static void main(String[] args) {
        School uniSopron = new School("Soproni Egyetem", 286);
        School primarySchool = new PrimarySchool("II. Rákóczi Ferenc Általános Iskola", 65);
        School secondarySchool = new SecondarySchool("Debreceni Református Kollégium", 483);

        System.out.println(primarySchool);
        System.out.println(secondarySchool);
        System.out.println(uniSopron);
    }
}
