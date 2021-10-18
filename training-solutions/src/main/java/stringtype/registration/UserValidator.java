package stringtype.registration;

public class UserValidator {

    private String name;
    private String password;
    private String passwordCheck;
    private String email;

    public void UserValidator (String name, String password, String passwordCheck, String email) {
        this.name = name;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public String getEmail () {
        return email;
    }

}
