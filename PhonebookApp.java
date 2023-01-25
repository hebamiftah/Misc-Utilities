import java.util.*;
import java.io.*;

public class PhonebookApp {
    public static void main(String[] args) {

        final String filename = "data/phonebook.txt";
        try {
            Phonebook phonebook = new Phonebook(filename, 100);
            int numElts = 0;

            Scanner keyboard = new Scanner(System.in);

            System.out.print("lookup, reverse-lookup, quit (l/r/q)? ");
            int numL = 0;
            int numR = 0;

            while (keyboard.hasNext()) {
                String option = keyboard.next();
                if (option.equals("l")) {
                    phonebook.lookup( keyboard);
                    numL++;
                } else if (option.equals("r")) {
                    phonebook.reverseLookup(keyboard);
                    numR++;
                } else if (option.equals("q")) {
                    System.out.println("\n" + numL + " lookups performed\n" + numR + " reverse lookups performed");
                    System.exit(0);
                }
                System.out.print("\nlookup, reverse-lookup, quit (l/r/q)? ");
            }
            keyboard.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("***IOException*** phonebook.text (No such file or directory)");
        }
        catch (Exception e) {
            System.out.println("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
        }
    }
}