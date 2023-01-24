import java.io.*;
import java.util.*;

public class FindLast{

    public static void main(String[] args) throws IOException {

//        Take input from user
//        print error message

        File file = new File("data/NumberPositions.txt");        //  Open File
        Scanner sc = new Scanner(file);                     //  Read File


        ArrayList<Integer> array = new ArrayList<>();
        while(sc.hasNext()){
            array.add(sc.nextInt());
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a number: ");

        while (keyboard.hasNextInt()){
            int number = keyboard.nextInt();
            // search
            if(array.contains(number)) {
                int position = array.lastIndexOf(number);
                System.out.println(number + " last appears in the file at position " + (position + 1));
            }
            else{
                System.out.println(number + " does not appear in the file");
            }

            System.out.print("Enter a number: ");
        }
    }
}