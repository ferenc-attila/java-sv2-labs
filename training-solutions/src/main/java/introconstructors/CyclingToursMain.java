package introconstructors;

import java.time.LocalDate;

public class CyclingToursMain {

    public static void main(String[] args) {

        CyclingTour tour = new CyclingTour("Balaton Circle", LocalDate.of(2021, 10, 02));
        System.out.print("description: " + tour.getDescription() + ";\n" +
                "start time: " + tour.getStartTime() + ";\n" +
                "number of people: " + tour.getNumberOfPeople() + ";\n" +
                "kilometers: " + tour.getKms() + ";\n");

        tour.registerPerson(5);
        System.out.print("description: " + tour.getDescription() + ";\n" +
                "start time: " + tour.getStartTime() + ";\n" +
                "number of people: " + tour.getNumberOfPeople() + ";\n" +
                "kilometers: " + tour.getKms() + ";\n");

        tour.registerPerson(2);
        System.out.print("description: " + tour.getDescription() + ";\n" +
                "start time: " + tour.getStartTime() + ";\n" +
                "number of people: " + tour.getNumberOfPeople() + ";\n" +
                "kilometers: " + tour.getKms() + ";\n");

        tour.ride(15);
        System.out.print("description: " + tour.getDescription() + ";\n" +
                "start time: " + tour.getStartTime() + ";\n" +
                "number of people: " + tour.getNumberOfPeople() + ";\n" +
                "kilometers: " + tour.getKms() + ";\n");

        tour.ride(20);
        System.out.print("description: " + tour.getDescription() + ";\n" +
                "start time: " + tour.getStartTime() + ";\n" +
                "number of people: " + tour.getNumberOfPeople() + ";\n" +
                "kilometers: " + tour.getKms() + ";\n");
    }
}
