import java.util.*;

public class NumberComparison {
  public static boolean allAreEqual(int a, int b, int c) {

    if (a == b && b == c && a == c)
        return true;

    else
        return false;
}

    public static boolean twoAreEqual(int a, int b, int c)
    {

        if (a == b && b == c && a == c)
            return false;
        else if (a == b)
            return true;
        else if (b == c)
            return true;
        else if (a == c)
            return true;
        else
            return false;
    }


    public static boolean noneAreEqual(int a, int b, int c) {

        if (a != b && b != c && a != c)
            return true;
        else
            return false;
    }

    public static boolean areAscending(int a, int b, int c)
    {

        if (a <= b && b <= c)
            return true;
        else
            return false;

    }

    public static boolean areDescending(int a, int b, int c)
    {

        if (a >= b && b >= c)
            return true;
        else
            return false;

    }

    public static boolean strictlyAscending(int a, int b, int c)
    {

        if (a < b && b < c)
            return true;
        else
            return false;
    }

    public static boolean strictlyDescending(int a, int b, int c)
    {

        if (a > b && b > c)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        int a, b, c;

        Scanner sc = new Scanner(System.in);

        System.out.print("first number? ");
        a = sc.nextInt();
        System.out.print("second number? ");
        b = sc.nextInt();
        System.out.print("third number? ");
        c = sc.nextInt();
        System.out.println("allAreEqual: " + allAreEqual(a, b, c));

        System.out.println("twoAreEqual: " + twoAreEqual(a, b, c));

        System.out.println("noneAreEqual: " + noneAreEqual(a, b, c));

        System.out.println("areAscending: " + areAscending(a, b, c));

        System.out.println("areDescending: " + areDescending(a, b, c));

        System.out.println("strictlyAscending: " + strictlyAscending(a, b, c));

        System.out.println("strictlyDescending: " + strictlyDescending(a, b, c));
    }
}
