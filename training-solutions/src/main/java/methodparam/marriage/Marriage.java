package methodparam.marriage;

import java.time.LocalDate;

public class Marriage {

    public void getMarried(Woman woman, Man man) {
        setMarriedName(woman, man);
        addMarriegeToRegisterDates(woman, man);
    }

    private void setMarriedName(Woman woman, Man man) {
        StringBuilder marriedName = new StringBuilder();
        marriedName.append(man.getName()).append("né ").append(woman.getName());
        woman.setName(marriedName.toString());
    }

    private void addMarriegeToRegisterDates(Woman woman, Man man) {
        RegisterDate registerDate = new RegisterDate("házasságkötés ideje", LocalDate.now());
        woman.addRegisterDate(registerDate);
        man.addRegisterDate(registerDate);
    }
}
