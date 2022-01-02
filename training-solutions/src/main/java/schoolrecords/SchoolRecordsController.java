package schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords classRecords = new ClassRecords("5/A", new Random());
    private List<Subject> subjects = new ArrayList<>();
    private List<Tutor> tutors = new ArrayList<>();
    private List<String> menu = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private void initSchool() {
        Subject literature = new Subject("irodalom");
        Subject grammar = new Subject("nyelvtan");
        Subject draw = new Subject("rajz");
        Subject music = new Subject("ének");
        Subject math = new Subject("matematika");
        Subject physics = new Subject("fizika");
        Subject chemistry = new Subject("kémia");
        Subject biology = new Subject("biológia");
        Subject geography = new Subject("földrajz");
        Subject pe = new Subject("testnevelés");
        subjects = Arrays.asList(literature, grammar, draw, music, math, physics, chemistry, biology, geography, pe);

        Tutor auntElis = new Tutor("Nagy Erzsébet", new ArrayList<>(Arrays.asList(literature, grammar)));
        Tutor auntKate = new Tutor("Szabó katalin", new ArrayList<>(Arrays.asList(draw, music)));
        Tutor uncleJoe = new Tutor("Kiss József", new ArrayList<>(Arrays.asList(physics, chemistry)));
        Tutor auntIli = new Tutor("Szabó Jánosné", new ArrayList<>(Arrays.asList(math, biology)));
        Tutor uncleDesi = new Tutor("Tóth Dezső", new ArrayList<>(Arrays.asList(geography, pe)));
        tutors = Arrays.asList(auntElis, auntKate, uncleJoe, auntIli, uncleDesi);
    }

    private StringBuilder printMenu() {
        menu = Arrays.asList("Diákok nevének listázása\n", "Diák név alapján keresése\n", "Diák létrehozása\n", "Diák név alapján törlése\n", "Diák feleltetése\n", "Osztályátlag kiszámolása\n", "Tantárgyi átlag kiszámolása\n", "Diákok átlagának megjelenítése\n", "Diák átlagának kiírása\n", "Diák tantárgyhoz tartozó átlagának kiírása\n", "Kilépés\n");
        StringBuilder menuBuilder = new StringBuilder("\nVálasszon egyet az alábbi lehetőségek közül, és adja meg sorszámát!\n");
        for (int i = 0; i < menu.size(); i++) {
            menuBuilder.append(i + 1).append(". ").append(menu.get(i));
        }
        return menuBuilder;
    }

    private String listStudentNames() {
        return classRecords.listStudentNames();
    }

    private String findStudentByName(String name) {
        try {
            isValidInputString(name);
            return classRecords.findStudentByName(name).toString();
        } catch (NullPointerException | IllegalArgumentException | IllegalStateException err) {
            return err.getMessage();
        }
    }

    private String addStudent(String name) {
        try {
            isValidInputString(name);
            return validateStudentBeforeAdd(name);
        } catch (NullPointerException err) {
            return err.getMessage();
        }
    }

    private String validateStudentBeforeAdd(String name) {
        if (classRecords.addStudent(new Student(name))) {
            return name + " nevű tanuló sikeresen létrehozva, és hozzáadva az osztályhoz.";
        } else {
            return "Már van ilyen nevű tanuló!";
        }
    }

    private String removeStudent(String name) {
        try {
            isValidInputString(name);
            Student student = classRecords.findStudentByName(name);
            classRecords.removeStudent(student);
            return name + " nevű tanuló sikeresen eltávolítva";
        } catch (NullPointerException | IllegalArgumentException | IllegalStateException err) {
            return err.getMessage();
        }
    }

    private boolean isValidInputString(String input) {
        if (input.isBlank()) {
            throw new NullPointerException("Null or empty input string!");
        }
        return true;
    }

    private String repetition() {
        try {
            return classRecords.repetition().getName();
        } catch (IllegalStateException ise) {
            return ise.getMessage();
        }
    }

    private String calculateClassAverage() {
        try {
            Double average = classRecords.calculateClassAverage();
            return average.toString();
        } catch (ArithmeticException ae) {
            return ae.getMessage();
        }
    }

    private String calculateClassAverageBySubject(String subject) {
        try {
            isValidInputString(subject);
            Subject actual = findSubject(subject);
            Double average = classRecords.calculateClassAverageBySubject(actual);
            return average.toString();
        } catch (NullPointerException | IllegalArgumentException err) {
            return err.getMessage();
        }
    }

    private Subject findSubject(String subject) {
        for (Subject actual : subjects) {
            if (actual.getSubjectName().equals(subject)) {
                return actual;
            }
        }
        throw new NullPointerException("Nincs ilyen néven regisztrált tantárgy!");
    }

    private String listStudyResults() {
        List<StudyResultByName> listOfStudyResults = classRecords.listStudyResults();
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (StudyResultByName actual : listOfStudyResults) {
            if (first) {
                result.append(actual.toString());
                first = false;
            } else {
                result.append(", ").append(actual);
            }
        }
        return result.toString();
    }

    private String calculateStudentAverage(String name) {
        try {
            isValidInputString(name);
            Student actual = classRecords.findStudentByName(name);
            Double average = actual.calculateAverage();
            return average.toString();
        } catch (NullPointerException | IllegalArgumentException | IllegalStateException err) {
            return err.getMessage();
        }
    }

    private String calculateStudentAverageBySubject(String name, String subject) {
        try {
            isValidInputString(name);
            isValidInputString(subject);
            Student student = classRecords.findStudentByName(name);
            Subject actual = findSubject(subject);
            Double result = student.calculateSubjectAverage(actual);
            return result.toString();
        } catch (NullPointerException | IllegalArgumentException | IllegalStateException err) {
            return err.getMessage();
        }
    }

    private String exit() {
        return "Viszontlátásra!";
    }

    private void selectFunction() {
        String menuItem = sc.nextLine();
        switch (menuItem) {
            case "1":
                System.out.println(listStudentNames());
                runMenu();
                break;
            case "2":
                String name = getInputString("Adja meg egy tanuló nevét!");
                System.out.println(findStudentByName(name));
                runMenu();
                break;
            case "3":
                name = getInputString("Adja meg az új tanuló nevét!");
                System.out.println(addStudent(name));
                runMenu();
                break;
            case "4":
                name = getInputString("Adja meg a törölni kívánt tanuló nevét!");
                System.out.println(removeStudent(name));
                runMenu();
                break;
            case "5":
                System.out.println(repetition());
                runMenu();
                break;
            case "6":
                System.out.println(calculateClassAverage());
                runMenu();
                break;
            case "7":
                String subject = getInputString("Adja meg a tantárgy nevét!");
                System.out.println(calculateClassAverageBySubject(subject));
                runMenu();
                break;
            case "8":
                System.out.println(listStudyResults());
                runMenu();
                break;
            case "9":
                name = getInputString("Adja meg a tanuló nevét!");
                System.out.println(calculateStudentAverage(name));
                runMenu();
                break;
            case "10":
                name = getInputString("Adja meg a tanuló nevét!");
                subject = getInputString("Adja meg a tantárgy nevét!");
                System.out.println(calculateStudentAverageBySubject(name, subject));
                runMenu();
                break;
            case "11":
                exit();
                break;
            default:
                System.out.println("Érvénytelen menüpont! A megadott érték 1 és 11 közötti szám lehet!");
                runMenu();
                break;
        }
    }

    private void runMenu() {
        System.out.println(printMenu());
        selectFunction();
    }

    private String getInputString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        SchoolRecordsController controller = new SchoolRecordsController();
        controller.initSchool();
        System.out.println(controller.classRecords.getClassName() + " osztály elektronikus osztálynaplója");
        controller.runMenu();
    }
}
