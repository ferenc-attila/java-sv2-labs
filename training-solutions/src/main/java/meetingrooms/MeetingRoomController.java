package meetingrooms;

import java.util.Scanner;

public class MeetingRoomController {

    Scanner scanner = new Scanner(System.in);
    Office office = new Office();

    public void readOffice () {
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
        System.out.println("1. Tárgyaló rögzítése\n" +
                "2. Tárgyalók sorrendben\n" +
                "3. Tárgyalók visszafele sorrendben\n" +
                "4. Minden második tárgyaló\n" +
                "5. Területek\n" +
                "6. Keresés pontos név alapján\n" +
                "7. Keresés névtöredék alapján\n" +
                "8. Keresés terület alapján\n" +
                "9. Kilépés\n");
    }

    public static void main(String[] args) {

        MeetingRoomController meetingRoomController = new MeetingRoomController();
    }
}
