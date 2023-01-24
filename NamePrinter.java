import java.io.*;
import java.util.*;

// Class
public class NamePrinter {
    private String first;
    private String last;


    public NamePrinter(String last, String first){
        this.first = first;
        this.last = last;
    }
    public NamePrinter(String first){
        this("", first);
    }

    public String getFormal(){
        return first + " " + last;
    }
    public String getOfficial(){
        return last + ", " + first;
    }
    public String getInitials(){
        char firstLetter = first.charAt(0);
        char secondLetter = last.charAt(0);
        return firstLetter+"."+secondLetter+".";
    }

    public boolean equals(NamePrinter other){
        return first.equals(other.first) && last.equals(other.last);
    }

    public static NamePrinter read(Scanner scanner){
        if(!scanner.hasNext()) return null;
        String last = scanner.next();
        String first = scanner.next();

        return new NamePrinter(last, first);
    }
    public String toString(){
        return first + " " + last;
    }
    static boolean findDuplicate(ArrayList<NamePrinter> namesList, NamePrinter name){
        for(int i = 0; i < namesList.size(); i++ ){
            if(namesList.get(i).equals(name)){
                return true;
            }
        }
        return false;
    }
    public static void main(String [] args) throws Exception{

        ArrayList<NamePrinter> nameList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("data/nameprint.txt"));
        int count = 0;
        NamePrinter name = read(scanner);

        while (name != null) {
            if (findDuplicate(nameList, name)) {
                System.out.println("Duplicate name \"" + name + "\"" + " discovered");
                name = read(scanner);
                count++;
            }
            else {
                nameList.add(name);
                System.out.println("name: "+name);
                System.out.println("formal: " + name.getFormal());
                System.out.println("official: " + name.getOfficial());
                System.out.println("initials: " + name.getInitials());
                System.out.println();
                count++;
                name = read(scanner);
            }
        }
        System.out.println("---");
        System.out.println(count + " names processed.");
    }
}
