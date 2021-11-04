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
        String[] menu = {"",
                "*** Tárgyaló nyilvántartás ***",
                "",
                "1. Tárgyaló rögzítése",
                "2. Tárgyalók sorrendben",
                "3. Tárgyalók visszafele sorrendben",
                "4. Minden második tárgyaló",
                "5. Területek",
                "6. Keresés pontos név alapján",
                "7. Keresés névtöredék alapján",
                "8. Keresés terület alapján",
                "9. Kilépés"};
        StringBuilder menuBuilder = new StringBuilder();
        for (String menuEntry : menu) {
            menuBuilder.append(menuEntry);
            menuBuilder.append("\n");
        }
        System.out.print(menuBuilder);
    }

    public void runMenu() {
        printMenu();
        System.out.println("Válasszon egyet a fenti lehetőségek közül, és adja meg annak sorszámát:");

        int selectedMenu = scanner.nextInt();
        scanner.nextLine();

        switch (selectedMenu) {
            case 1 -> {
                readOffice();
                runMenu();
            }
            case 2 -> {
                office.printNames();
                runMenu();
            }
            case 3 -> {
                office.printNamesReverse();
                runMenu();
            }
            case 4 -> {
                office.printEvenNames();
                runMenu();
            }
            case 5 -> {
                office.printAreas();
                runMenu();
            }
            case 6 -> {
                System.out.println("Adja meg a keresendő tárgyaló nevét:");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
                runMenu();
            }
            case 7 -> {
                System.out.println("Adja meg, milyen kifejezést keressek a tárgyalók nevében:");
                String part = scanner.nextLine();
                office.printMeetingRoomsContains(part);
                runMenu();
            }
            case 8 -> {
                System.out.println("Adja meg, mekkora területnél keressek nagyobb méretű tárgyalót:");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                runMenu();
            }
            case 9 -> System.out.println("Köszönjük, hogy használta szoftverünket! Viszontlátásra!");
            default -> runMenu();
        }
    }

    public static void main(String[] args) {

        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }
}
