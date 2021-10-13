package classstructureattributes;

import java.util.Scanner;

public class SongMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Song song = new Song();

        System.out.println("Which band plays your favourite song?");
        song.band = scanner.nextLine();

        System.out.println("What's the title of that song?");
        song.title = scanner.nextLine();

        System.out.println("How long is that song (in minutes)?");
        song.length = scanner.nextInt();
        scanner.nextLine();

        System.out.println(song.band + " - " + song.title + " (" + song.length + " minutes)");

    }

}
