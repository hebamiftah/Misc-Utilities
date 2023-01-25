import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Phonebook {
    private ArrayList<PhonebookEntry> entries;
    static int capacity;
    int noOfEntries;

    Phonebook(String filename, int capacity) throws Exception {
        entries = new ArrayList<PhonebookEntry>(capacity);
        this.capacity = capacity;
        noOfEntries = 0;

        Scanner inputFile = new Scanner(new File(filename));
        while (inputFile.hasNext()) {
            PhonebookEntry entry = PhonebookEntry.read(inputFile);
            if (noOfEntries >= capacity) {
                throw new Exception("over capacity");
            }
            entries.add(entry);
            noOfEntries++;
        }
        inputFile.close();

    }

    Phonebook(int capacity) {
        entries = new ArrayList<PhonebookEntry>(capacity);
        this.capacity = capacity;
    }

    // look up first & last name
    public boolean lookup(Scanner sc) {
        String fName, lName;
        System.out.print("last name? ");
        lName = sc.next();
        System.out.print("first name? ");
        fName = sc.next();

        PhonebookName name = new PhonebookName(lName, fName);

        for (int i = 0; i < this.noOfEntries; i++) {
            if (entries.get(i).getName().equals(name)) {
                System.out.println(name.getFormal() + "'s phone number is " + entries.get(i).getPhoneNumbers());
                return true;
            }
        }
        System.out.println("-- Name not found");
        return false;
    }

    //reverse lookup phone number
    public boolean reverseLookup(Scanner sc) {
        String phoneNumber;
        System.out.print("phone number (nnn)nnn-nnnn? ");
        phoneNumber = sc.next();

        PhoneNumber number = new PhoneNumber(phoneNumber);

        for (int i = 0; i < noOfEntries; i++) {
            PhonebookEntry entry = entries.get(i);
            for (int j = 0; j < entry.getPhoneNumbers().size(); j++) {
                if (entries.get(i).getPhoneNumbers().get(j).equals(number)) {
                    System.out.println(number + " belongs to " + entries.get(i).getName().getFormal());
                    return true;
                }
            }
        }
        System.out.println("-- Phone number not found");
        return false;
    }

}