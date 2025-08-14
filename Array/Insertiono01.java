import java.util.Scanner;

public class Insertiono01 {
    public static void main(String[] args) {
        int arr[] = {5, 2, 9, 1, 5, 6};
        Scanner sc = new Scanner(System.in);

        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // Ask user for the choice
        System.out.println("\n\nChoose insertion option:");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Insert at Specific Index");
        int choice = sc.nextInt();

        // Ask user for the new value
        System.out.print("Enter the value to insert: ");
        int newValue = sc.nextInt();

        int[] newArr = new int[arr.length + 1];

        switch (choice) {
            case 1: // Insert at beginning
                newArr[0] = newValue;
                for (int i = 0; i < arr.length; i++) {
                    newArr[i + 1] = arr[i];
                }
                break;

            case 2: // Insert at end
                for (int i = 0; i < arr.length; i++) {
                    newArr[i] = arr[i];
                }
                newArr[newArr.length - 1] = newValue;
                break;

            case 3: // Insert at specific index
                System.out.print("Enter the index (0 to " + arr.length + "): ");
                int index = sc.nextInt();

                if (index < 0 || index > arr.length) {
                    System.out.println("Invalid index!");
                    return;
                }

                for (int i = 0, j = 0; i < newArr.length; i++) {
                    if (i == index) {
                        newArr[i] = newValue;
                    } else {
                        newArr[i] = arr[j++];
                    }
                }
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Print final array
        System.out.println("\nArray after insertion:");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}
