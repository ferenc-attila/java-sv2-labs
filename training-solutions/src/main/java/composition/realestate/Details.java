package composition.realestate;

public class Details {

    private String description;
    private Address address;
    private int squareMeter;
    private int areaOfSite;

    public Details(String description, Address address, int squareMeter, int areaOfSite) {
        this.description = description;
        this.address = address;
        this.squareMeter = squareMeter;
        this.areaOfSite = areaOfSite;
    }

    public String toString() {
        return "description: " + description + ";\n" +
                "address: " + address.toString() + ";\n" +
                "area: " + squareMeter + " m2\n" +
                "area of site: " + areaOfSite + " m2\n";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getSquareMeter() {
        return squareMeter;
    }

    public void setSquareMeter(int squareMeter) {
        this.squareMeter = squareMeter;
    }

    public int getAreaOfSite() {
        return areaOfSite;
    }

    public void setAreaOfSite(int areaOfSite) {
        this.areaOfSite = areaOfSite;
    }
}
