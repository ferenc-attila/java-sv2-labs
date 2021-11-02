package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    Scanner scanner = new Scanner(System.in);
    Office office = new Office();

    public void readOffice() {
        System.out.println("Adja meg a tárgyaló nevét:");
        String name = scanner.nextLine();
        System.out.println("Adja meg a tárgyaló szélességét:");
        int width = scanner.nextInt();
        scanner.nextLine();
        System.out.println(("Adja meg a tárgyaló hosszúságát:"));
        int length = scanner.nextInt();
        scanner.nextLine();

        office.addMeetingRoom(new MeetingRoom(name, length, width));
    }

    public void printMenu() {
        System.out.println("\n*** Tárgyaló nyilvántartás ***\n" +
                "\n" +
                "1. Tárgyaló rögzítése\n" +
                "2. Tárgyalók sorrendben\n" +
                "3. Tárgyalók visszafele sorrendben\n" +
                "4. Minden második tárgyaló\n" +
                "5. Területek\n" +
                "6. Keresés pontos név alapján\n" +
                "7. Keresés névtöredék alapján\n" +
                "8. Keresés terület alapján\n" +
                "9. Kilépés\n");
    }

    public void runMenu() {
        printMenu();
        System.out.println("Válasszon egyet a fenti lehetőségek közül, és adja meg annak sorszámát:");

        int selectedMenu = scanner.nextInt();
        scanner.nextLine();

        switch (selectedMenu) {
            case 1:
                readOffice();
                runMenu();
                break;
            case 2:
                office.printNames();
                runMenu();
                break;
            case 3:
                office.printNamesReverse();
                runMenu();
                break;
            case 4:
                office.printEvenNames();
                runMenu();
                break;
            case 5:
                office.printAreas();
                runMenu();
                break;
            case 6:
                System.out.println("Adja meg a keresendő tárgyaló nevét:");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
                runMenu();
                break;
            case 7:
                System.out.println("Adja meg, milyen kifejezést keressek a tárgyalók nevében:");
                String part = scanner.nextLine();
                office.printMeetingRoomsContains(part);
                runMenu();
                break;
            case 8:
                System.out.println("Adja meg, mekkora területnél keressek nagyobb méretű tárgyalót:");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                runMenu();
                break;
            case 9:
                System.out.println("Köszönjük, hogy használta szoftverünket! Viszontlátásra!");
                break;
            default:
                runMenu();
        }
    }

    public static void main(String[] args) {

        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }
}
