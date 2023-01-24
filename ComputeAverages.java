import java.io.*;
import java.util.Scanner;

public class ComputeAverages{
    // Average Function
    static double average(int [] arr){
        // avg = sum/total_numbers
        int total_numbers = arr.length;
        double sum = 0;
        for(int i = 0; i< total_numbers; i++){
            sum = sum + arr[i];
        }
        return sum/total_numbers;
    }

    // Printing Details Function
    static void printDetails(int [] arr){
        System.out.print("The average of the " + arr.length + " integers ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("is " + average(arr));
    }

    // main
    public static void main(String[] args) throws IOException {

        File file = new File("data/averages.txt");        //  Open File
        Scanner sc = new Scanner(file);                     //  Read File

        int count = 0;
        while(sc.hasNext()){
            int header = sc.nextInt();                  // reading header
            int [] arr = new int[header];               // making array

            for(int i=0; i<header; i++){                // reading row values
                arr[i] = sc.nextInt();
            }
            printDetails(arr);                          //  Print details and average
            count++;
        }
        System.out.println(count + " sets of numbers processed");
    }
}