package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song favouriteSong = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérlek, add meg az előadót!");
        favouriteSong.band = scanner.nextLine();
        System.out.println("Kérlek, add meg a dal címét!");
        favouriteSong.song = scanner.nextLine();
        System.out.println("Kérlek add meg a dal hosszát percben!");
        favouriteSong.length = scanner.nextInt();

        System.out.println(favouriteSong.band + " - " + favouriteSong.song + " (" + favouriteSong.length + " perc)");
    }
}
