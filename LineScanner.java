import java.io.*;
import java.util.Scanner;

public class LineScanner {
    public static void main (String args[]) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("data/Scannernumbers.txt"));

        int lineCount =1;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            int count = 0;

            while (lineScanner.hasNextInt()){
                count++;
                lineScanner.nextInt();
            }
            System.out.println("There are "+count+" numbers on line "+ lineCount);
            lineCount++;
        }
    }
}