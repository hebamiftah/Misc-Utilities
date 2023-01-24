import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneNumber {
    private String number;          // Data Field of Number

    // Constructor
    public PhoneNumber(String number){
        this.number = number;
    }

    // will return area code
    public String getAreaCode(){
        String areaCode = number.substring(1, 4);
        return areaCode;
    }

    // will return exchange number from the number (middle)
    public String getExchange(){
        String exchangeNumber = number.substring(5, 8);
        return exchangeNumber;
    }

    // this number will return last 4 digits
    // (342) 182-9172
    public String getLineNumber(){
        String lineNumber = number.substring(9, 13 );
        return lineNumber;
    }

    // it will return either a number is toll free or not
    // number is tool free if it starts with '8'
    public boolean isTollFree(){
        char firstNumber = number.charAt(1);
        if(firstNumber == '8'){
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        return number;
    }
    // checking if equal or not
    public boolean equals(PhoneNumber other){
        boolean check = number.equals(other.number);
        return check;
    }
    // for reading data of PhoneNumner
    public static PhoneNumber read(Scanner sc){
        if(!sc.hasNext()) return null;
        String phoneNumber = sc.nextLine();

        return new PhoneNumber(phoneNumber);
    }

    // find our duplicates
    static boolean findDuplicate(ArrayList<PhoneNumber> numbersList, PhoneNumber num){
        for(int i = 0; i < numbersList.size(); i++ ){
            if(numbersList.get(i).equals(num)){
                return true;
            }
        }
        return false;
    }
    // main method
    public static void main(String [] args) throws FileNotFoundException {
        ArrayList<PhoneNumber> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(new File("data/phonenumbers.txt"));
        int count = 0;
        PhoneNumber number = read(scanner);

        while (number != null) {
            if(findDuplicate(numberList, number )){
                System.out.println("Duplicate phone number \""+ number + "\" discovered");
                number = read(scanner);
                count++;
            }
            else{
                System.out.println("phone number: " + number);
                System.out.println("area code: " + number.getAreaCode());
                System.out.println("exchange: " + number.getExchange());
                System.out.println("line number: " + number.getLineNumber());
                System.out.println("is toll free: " + number.isTollFree());
                System.out.println();
                numberList.add(number);
                number = read(scanner);
                count++;
            }
        }
        System.out.println("---");
        System.out.println(count + " phone numbers processed.");

    }
}