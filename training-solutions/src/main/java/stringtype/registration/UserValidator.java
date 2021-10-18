package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        boolean isValidUsername = username.equals("");
        return !isValidUsername;
    }

    public boolean isValidPassword(String password1, String password2) {
        boolean isValidPassword = password1.equals(password2) && password1.length() >= 8;
        return  isValidPassword;
    }

    public boolean isValidEmail(String email) {

        int indexOfAtSign = email.indexOf("@", 1);
        int indexOfDot = email.indexOf(".");
        int emailStringLength = email.length();

        boolean isValidEmail = indexOfAtSign != -1 && indexOfDot > indexOfAtSign+1 && indexOfDot < emailStringLength-2;
        return isValidEmail;
    }

}
