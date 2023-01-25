import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
public class AuthenticatorApp {
    // main
    public static void main(String[] args) {
        try {
            AuthenticateLogin login = new AuthenticateLogin("data/Logininfo.txt");
            Scanner sc = new Scanner(System.in);

            int tries = 0;

            while (tries < 3) {
                System.out.print("username? ");
                String userName = sc.next();
                System.out.print("password? ");
                String password = sc.next();
                try {
                    login.authenticate(userName, password);
                    System.out.println("Welcome to the system");
                    break;
                } catch (Exception e) {
                    System.out.println("*** " + e.getMessage());
                    tries++;
                }

                if (tries == 3) {
                    System.out.println("Too many failed attempts... please try again later");
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}