package controller;

import java.util.Scanner;

public class Main {

    private final String[] menu = {"\n*** SARS COVID-19 vakcináció ***\n",
            "Regisztráció",
            "Tömeges regisztráció",
            "Generálás",
            "Oltás",
            "Oltás meghiúsulás",
            "Riport",
            "Kilépés"};

    private Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        printMenu();

        System.out.println("Válasszon egyet a fenti lehetőségek közül, és adja meg annak sorszámát:");
        String selectedMenu = scanner.nextLine();
        switch (selectedMenu) {
            case "1":
                registration();
                runMenu();
                break;
            case "2":
                massRegistration();
                runMenu();
                break;
            case "3":
                generateListOfVaccinations();
                runMenu();
                break;
            case "4":
                vaccination();
                runMenu();
                break;
            case "5":
                failedVaccination();
                runMenu();
                break;
            case "6":
                report();
                runMenu();
                break;
            case "7":
                System.out.println("Köszönjük, hogy használta szoftverünket! Viszontlátásra!");
                break;
            default:
                runMenu();
        }
    }

    private void registration() {
        System.out.println("Registration");
    }

    private void massRegistration() {
        System.out.println("Mass registration");
    }

    private void generateListOfVaccinations() {
        System.out.println("Generating list of vaccination");
    }

    private void vaccination() {
        System.out.println("Vaccination");
    }

    private void failedVaccination() {
        System.out.println("Failed vaccination");
    }

    private void report() {
        System.out.println("Riport");
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
        Main main = new Main();
        main.runMenu();
    }
}
