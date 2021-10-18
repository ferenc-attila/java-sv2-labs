package stringtype.registration;

public class UserValidator {

    private String name;
    private String password1;
    private String password2;
    private String email;

    public void UserValidator (String name, String password, String passwordCheck, String email) {
        this.name = name;
        this.password1 = password;
        this.password2 = passwordCheck;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password1;
    }

    public String getPassword2() {
        return password2;
    }

    public String getEmail () {
        return email;
    }

}
