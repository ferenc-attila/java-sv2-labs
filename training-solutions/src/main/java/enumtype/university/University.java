package enumtype.university;

public enum University {

    BME("Budapesti Műszaki és Gazdaságtudományi Egyetem"), DE("Debreceni Egyetem"), SE("Soproni Egyetem"), EKE("Eszterházy Károly Egyetem");

    private final String name;

    University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
