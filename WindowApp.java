import javax.swing.plaf.SeparatorUI;
import java.io.File;
import java.util.Scanner;

public class WindowApp {
    // main method
    public static void main(String[] args) {
        // create window array of 25 elements
        Window[] windows = new Window[25];
        int count = 0;
        // open the Windowappdata.data file
        File file = new File("data/Windowappdata.data");
        // create a scanner to read the file
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
        // read the type of window
        while (scanner.hasNext()) {

            String type = scanner.next();
            if (type.equals("C")) {
                ColoredWindow window = ColoredWindow.read(scanner);
                windows[count] = window;
                count++;
            } else if (type.equals("B")) {
                BorderedWindow window = BorderedWindow.read(scanner);
                windows[count] = window;
                count++;
            }
        }
        System.out.println("Creating window data from file data, loading it into an array, and displaying");
        // iterate through the array
        for (int i = 0; i < count; i++) {
            windows[i].setVisible(false);
            // display the window
            System.out.println("--- Window " + (i) +": " + windows[i].toString());
            System.out.println("(Nothing to see here)");
            System.out.println();
        }
        System.out.println();
        System.out.println("Turning on visibility");
        for (int i = 0; i < count; i++) {
            System.out.println("--- Window " + (i) +  ": " + windows[i].toString());
            windows[i].setVisible(true);
            windows[i].display();
            System.out.println();
        }
        System.out.println();

        System.out.println("Resizing (flipping width and height) and displaying");
        for (int i = 0; i < count; i++) {
            windows[i].resize(windows[i].getHeight(), windows[i].getWidth());
            System.out.println("--- Window " + (i) +  ": " + windows[i].toString());
            windows[i].display();
            System.out.println();
        }
        System.out.println();

        System.out.println("Minimizing and Displaying");
        for (int i = 0; i < count; i++) {
            windows[i].minimize();
            System.out.println("--- Window " + (i) +  ": " + windows[i].toString());
            windows[i].display();
        }


    }
}