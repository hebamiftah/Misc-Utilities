import java.io.*;
import java.util.Scanner;

public class ArrayInfo{

    // Printing Details Function
    static void printDetails(double [] arr){
        System.out.print("The array: {");

        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]);


            if(i != arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.println("} contains " + arr.length + " elements");
    }

    static void largest(double [] arr){

        double largest = -500.0;
        int pos = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
                pos = i;
            }
        }
        System.out.println("The largest element of the array is " + largest + " and is at position " + pos);
    }


    static void smallest(double [] arr){

        double smallest = 2000.0;
        int pos = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < smallest){
                smallest = arr[i];
                pos = i;
            }
        }
        System.out.println("The smallest element of the array is " + smallest + " and is at position " + pos);
    }


    // main
    public static void main(String[] args) throws IOException {

        File file = new File("data/ArrayInfo.txt");        //  Open File
        Scanner sc = new Scanner(file);                     //  Read File
        //  Read Header
        int header = sc.nextInt();

        //  Read the Doubles
        double [] array = new double[header];

        // Read Double Values from File
        for(int i=0; i<header; i++){
            array[i] = sc.nextDouble();
        }

        // Output Array
        printDetails(array);
        System.out.println("The first element of the array is "+ array[0]);
        // Last Element
        System.out.println("The last element of the array is " + array[(array.length - 1)] + " and is at position " + (array.length - 1));

        //middle = (first+last)/2
        int middle = (0 + array.length-1) / 2;
        System.out.println("The middle element of the array is " + array[middle] + " and is at position " + middle);

        // Largest Element
        largest(array);
        smallest(array);


    }
}