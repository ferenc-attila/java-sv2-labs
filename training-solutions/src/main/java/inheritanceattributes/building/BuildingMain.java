package inheritanceattributes.building;

public class BuildingMain {

    public static void main(String[] args) {
        Building building = new Building("Museum", 1500, 3);
        SchoolBuilding schoolBuilding = new SchoolBuilding("Primary School", 1800, 4, 12);

        System.out.println(building.name);
        System.out.println(building.area);
        System.out.println(building.getFloors());

        System.out.println(schoolBuilding.name);
        System.out.println(schoolBuilding.area);
        System.out.println(schoolBuilding.getFloors());
        System.out.println(schoolBuilding.getNumberOfClassRooms());
    }
}
