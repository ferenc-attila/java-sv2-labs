package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    private final Office office = new Office();
    private final String[] menu = {"\n*** Tárgyaló nyilvántartás ***\n",
            "Tárgyaló rögzítése",
            "Tárgyalók sorrendben",
            "Tárgyalók visszafele sorrendben",
            "Minden második tárgyaló",
            "Területek",
            "Keresés pontos név alapján",
            "Keresés névtöredék alapján",
            "Keresés terület alapján",
            "Kilépés"};

    Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        printMenu();

        System.out.println("Válasszon egyet a fenti lehetőségek közül, és adja meg annak sorszámát:");
        String selectedMenu = scanner.nextLine();
        switch (selectedMenu) {
            case "1":
                readOffice();
                runMenu();
                break;
            case "2":
                office.printNames();
                runMenu();
                break;
            case "3":
                office.printNamesReverse();
                runMenu();
                break;
            case "4":
                office.printEvenNames();
                runMenu();
                break;
            case "5":
                office.printAreas();
                runMenu();
                break;
            case "6":
                System.out.println("Adja meg a keresendő tárgyaló nevét:");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
                runMenu();
                break;
            case "7":
                System.out.println("Adja meg, milyen kifejezést keressek a tárgyalók nevében:");
                String part = scanner.nextLine();
                office.printMeetingRoomsContains(part);
                runMenu();
                break;
            case "8":
                System.out.println("Adja meg, mekkora területnél keressek nagyobb méretű tárgyalót:");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
                runMenu();
                break;
            case "9":
                System.out.println("Köszönjük, hogy használta szoftverünket! Viszontlátásra!");
                break;
            default:
                runMenu();
        }
    }

    private void readOffice() {
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

    private void printMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        for (int i = 0; i < menu.length; i++) {
            if (i > 0) {
                menuBuilder.append(i).append(": ");
            }
            menuBuilder.append(menu[i]);
            menuBuilder.append("\n");
        }
        System.out.print(menuBuilder);
    }

    public static void main(String[] args) {

        MeetingRoomController meetingRoomController = new MeetingRoomController();
        meetingRoomController.runMenu();
    }
}
