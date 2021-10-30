package stringbasic.university;

public class Person {

    private String name;
    private String email;
    private String TAJ;
    private String BankAccountNumber;
    private String phoneNumber;

    public Person(String name, String email, String TAJ, String bankAccountNumber, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.TAJ = TAJ;
        BankAccountNumber = bankAccountNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTAJ() {
        return TAJ;
    }

    public void setTAJ(String TAJ) {
        this.TAJ = TAJ;
    }

    public String getBankAccountNumber() {
        return BankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        BankAccountNumber = bankAccountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
