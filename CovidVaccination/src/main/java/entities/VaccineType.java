package entities;

public class VaccineType {

    private Long id;
    private String name;
    private int primarySeries;
    private int minAge;
    private int maxAge;

    public VaccineType(Long id, String name, int primarySeries, int minAge, int maxAge) {
        this.id = id;
        this.name = name;
        this.primarySeries = primarySeries;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrimarySeries() {
        return primarySeries;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }
}
