import java.util.Scanner;

public class ColoredWindow extends Window {
    private char color;

    public ColoredWindow(int width, int height, char color) {
        super(width, height);
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public void displayNormal() {
        // fill the window with the color
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                System.out.print(color);
            }
            System.out.println();
        }
    }

    // static read method
    public static ColoredWindow read(Scanner scanner) {
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        char color = scanner.next().charAt(0);
        return new ColoredWindow(width, height, color);
    }

    public void display() {
        String result = "";
        if (!super.isVisible()) {
            System.out.println("(Nothing to see here)");
        } else {
            if (super.isMinimized()) {
                System.out.println( "[a " + super.getWidth() + "x" + super.getHeight() + " window with background color '" + color + "' (minimized)]");
            } else {
                displayNormal();
            }
        }
    }
}
