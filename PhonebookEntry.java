import java.util.ArrayList;
import java.util.Scanner;

// PhonebookEntry class
class PhonebookEntry {
    private PhonebookName name;
    private ArrayList<PhoneNumber> phoneNumbers;

    public PhonebookEntry(PhonebookName name, ArrayList<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }
    public PhonebookName getName(){
        return name;
    }

    public ArrayList<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }
    public void addPhoneNumber(PhoneNumber phoneNumber){
        phoneNumbers.add(phoneNumber);
    }

    public static PhonebookEntry read(Scanner sc){
        PhonebookName n1 = PhonebookName.read(sc);
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        int size = sc.nextInt();
        while (size > 0) {
            PhoneNumber p1 = PhoneNumber.read(sc);
            phoneNumbers.add(p1);
            size--;
        }
        return new PhonebookEntry(n1, phoneNumbers);
    }
}
