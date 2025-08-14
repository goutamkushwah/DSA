import java.util.Scanner;

public class searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take string input
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        // Take character input
        System.out.print("Enter a character to search: ");
        char a = scanner.next().charAt(0); // Read first character of input

        int index = -1;
        boolean found = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a) {
                index = i;
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Character '" + a + "' found at index: " + index);
        } else {
            System.out.println("Character '" + a + "' not found.");
        }

        scanner.close(); // Always close the Scanner
    }
}
