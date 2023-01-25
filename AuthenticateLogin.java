import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


 class AuthenticateLogin {

    // fields
    private User [] users;
    private int size;           // this variable will tell how many users the array contains

    // methods
    AuthenticateLogin(String fileName) throws FileNotFoundException {
        // initialize the fields
        users = new User[100];
        size = 0;

        // open the file
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        // reading the data
        User user = User.read(sc);
        while (user != null){
            users[size] = user;
            size++;

            user = User.read(sc);
        }

    }

    public void authenticate(String userName, String password) throws Exception {
        // searching
        for(int i=0; i<size; i++ ){
            if(this.users[i].getUsername().equals(userName)){
                if(this.users[i].verifyPassword(password))
                    return;
                else
                    throw new Exception("Invalid password - hint: " + users[i].getHint());
            }
        }

        throw new Exception("User is not Found");
    }

}
