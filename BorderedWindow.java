import java.util.Scanner;
public class BorderedWindow extends Window{
    public BorderedWindow(int width, int height) {
        super(width, height);
    }
    public int getWidth() {
        return super.getWidth();
    }
    public int getHeight() {
        return super.getHeight();
    }
    public String toString() {
        return "a " + getWidth() + "x" + getHeight() + " bordered window";
    }
    public void displayNormal() {
        System.out.println("+" + "-".repeat(getWidth()) + "+");
        for (int i = 0; i < super.getHeight(); i++) {
            System.out.println("|" + " ".repeat(getWidth() ) + "|");
        }
        System.out.println("+" + "-".repeat(getWidth()) + "+");
    }
    public void display() {
        if (!super.isVisible()) {
            System.out.println("(Nothing to see here)");
        } else {
            if (super.isMinimized()) {
                System.out.println("[a "+super.getWidth()+"x"+super.getHeight()+" window with a border (minimized)]");                } else {
                displayNormal();
            }
        }
    }
    // static read method
    public static BorderedWindow read(Scanner scanner) {
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        return new BorderedWindow(width, height);
    }
}
