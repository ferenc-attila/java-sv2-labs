package stringtype.registration;

import java.util.Scanner;

public class  Registration {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserValidator userValidator = new UserValidator();

        System.out.println("Enter a username:");
        String username = scanner.nextLine();
        boolean isValidUsername = userValidator.isValidUsername(username);
        System.out.println(isValidUsername ? "The entered username is correct." : "The entered username isn't correct!");
        System.out.println("Enter a password (at least 8 characters):");
        String password1 = scanner.nextLine();
        System.out.println("Verify your password:");
        String password2 = scanner.nextLine();
        boolean isValidPassword = userValidator.isValidPassword(password1, password2);
        System.out.println(isValidPassword ? "The entered password is correct." : "The entered password isn't correct!");
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        boolean isValidEmail = userValidator.isValidEmail(email);
        System.out.println(isValidEmail ? "The entered email is correct." : "The entered email isn't correct!");
    }

}
