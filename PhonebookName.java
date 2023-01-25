import java.util.Scanner;

// Name class
class PhonebookName {
    private String first;
    private String last;

    public PhonebookName(String last, String first) {
        this.first = first;
        this.last = last;
    }

    public PhonebookName(String first) {
        this("", first);
    }

    public String getFormal() {
        return first + " " + last;
    }

    public String getOfficial() {
        return last + ", " + first;
    }

    public String getInitials() {
        char firstLetter = first.charAt(0);
        char secondLetter = last.charAt(0);
        return firstLetter + "." + secondLetter + ".";
    }

    public boolean equals(PhonebookName other) {
        return first.equals(other.first) && last.equals(other.last);
    }

    public static PhonebookName read(Scanner scanner) {
        if (!scanner.hasNext()) return null;
        String last = scanner.next();
        String first = scanner.next();

        return new PhonebookName(last, first);
    }

    public String toString() {
        return first + " " + last;
    }
}
