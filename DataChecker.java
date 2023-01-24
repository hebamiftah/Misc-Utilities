import java.io.*;
import java.util.Scanner;

public class DataChecker {
    public static void main(String args[]) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("data/ValidationData.txt"));
        int lineCount = 1;
        int validLines = 0;
        int corruptLines = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            if (line.equals("")) {
                System.out.println("*** Error (line " + lineCount + "): Line is empty - average can't be taken");
                corruptLines++;
            }
            else {
                Scanner lineScanner = new Scanner(line);
                int count = 0;
                int header = lineScanner.nextInt();

                if (header == 0) {
                    System.out.println("*** Error (line " + lineCount + "): Header value of 0 - average can't be taken");
                    corruptLines++;
                } else if (header < 0) {
                    System.out.println("*** Error (line " + lineCount + "): Corrupt line - negative header value");
                    corruptLines++;
                } else {
                    int sum = 0;

                    while (lineScanner.hasNextInt()) {
                        count++;
                        sum = sum + lineScanner.nextInt();
                    }

                    if (count < header) {
                        System.out.println("*** Error (line " + lineCount + "): Corrupt line - fewer values than header");
                        corruptLines++;
                    } else if (count > header) {
                        System.out.println("*** Error (line " + lineCount + "): Corrupt line - extra values on line");
                        corruptLines++;
                    } else {
                        System.out.println("The average of the values on line " + lineCount + " is " + (double) sum / count);
                        validLines++;
                    }
                }
            }
            lineCount++;
        }
        System.out.println("\nThere were "+validLines+" valid lines of data");
        System.out.println("There were "+corruptLines+" corrupt lines of data");
    }
}