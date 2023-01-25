import java.util.Scanner;

class User {
    // Private Data Fields
    // username, password, password-hint
    private String userName;
    private String password;
    private String passwordHint;

    //constructor()
    public User(String username, String password, String passwordHint) {
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
    public static User read(Scanner sc) {
        if (!sc.hasNext()) return null;

        String userName = sc.next();
        String password = sc.next();
        String passwordHint = sc.next();

        User user = new User(userName, password, passwordHint);
        return user;
    }


}
