package methodparam.marriage;

import java.util.List;

public class Woman {

    private String name;
    private List<RegisterDate> registerDates;

    public Woman(String name, List<RegisterDate> registerDates) {
        if (name == null || (!name.trim().contains(" "))) {
            throw new IllegalArgumentException("Not a valid name!");
        }
        this.name = name;
        this.registerDates = registerDates;
    }

    public void addRegisterDate(RegisterDate registerDate) {
        registerDates.add(registerDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RegisterDate> getRegisterDates() {
        return registerDates;
    }
}
