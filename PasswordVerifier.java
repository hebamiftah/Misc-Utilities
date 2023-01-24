import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PasswordVerifier {
    // Private Data Fields
    // username, password, password-hint
    private String userName;
    private String password;
    private String passwordHint;

    //constructor()
    public PasswordVerifier(String username, String password, String passwordHint) {
        this.userName = username;
        this.password = password;
        this.passwordHint = passwordHint;
    }

    //getUserName ()
    public String getUsername() {
        return userName;
    }

    //getHint()
    public String getHint() {
        return passwordHint;
    }

    //verifyPassword(String pw)
    public boolean verifyPassword(String password) {
        // check for equal case
        if (this.password.equals(password))
            return true;
        else
            return false;
    }

    //toString()
    public String toString() {
        return "User " + userName;
    }

    //read(Scanner sc)
    public static PasswordVerifier read(Scanner sc) {
        if (!sc.hasNext()) return null;

        String userName = sc.next();
        String password = sc.next();
        String passwordHint = sc.next();

        PasswordVerifier user = new PasswordVerifier(userName, password, passwordHint);
        return user;
    }

    // main method
    public static void main(String[] args) throws FileNotFoundException {
        // Open the file
        File file = new File("data/Users.data");
        Scanner sc = new Scanner(file);

        PasswordVerifier user = PasswordVerifier.read(sc);
        // if there are more users in the file
        while (user != null) {
            System.out.println("User " + user + " hint: " + user.getHint());
            boolean compare = user.verifyPassword(user.getUsername());

            if (compare) {
                System.out.println("*** Error the password should not be same as the user name");
            } else {
                System.out.println("OK -- the password is different from the user name");
            }

            user = PasswordVerifier.read(sc);
        }

    }
}
