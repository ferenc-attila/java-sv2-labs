package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return !username.equals("");
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.equals(password2) && password1.length() >= 8;
    }

    public boolean isValidEmail(String email) {

        int emailStringLength = email.length();
        int indexOfAtSign = email.indexOf("@", 1);
        int indexOfDot = email.indexOf(".", indexOfAtSign+2);

        return indexOfAtSign != -1 && indexOfDot != -1 && indexOfDot < emailStringLength-1;
    }

}
