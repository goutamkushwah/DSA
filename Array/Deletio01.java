import java.util.Scanner;
public class Deletio01 {
public static void main(String[] args) {
        int arr[] = {5, 2, 9, 1, 5, 6};
        Scanner sc = new Scanner(System.in);

        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        // Ask user for the choice
        System.out.println("\n\nChoose insertion option:");
        System.out.println("1. Delete at Beginning");
        System.out.println("2. Delete at End");
        System.out.println("3. Delete at Specific Index");
        System.out.print("Enter the value to Delete: ");
        int choice = sc.nextInt();
        int newArr[]= new int[arr.length - 1];
        // Ask user for the new value
        
        switch (choice) {
            case 1: // Insert at beginning
            //start index 1 because skipp fisrt element postion goes in -1 and there one error occerd
                      for (int i = 1; i < arr.length; i++) {
                    newArr[i-1 ] = arr[i];
                }
                break;

            case 2: // Insert at end
                for (int i = 0; i < arr.length-1; i++) {
                    newArr[i] = arr[i];
                }
                break;

            case 3: // Insert at specific index
                System.out.print("Enter the index (0 to " + arr.length + "): ");
                int index = sc.nextInt();

                if (index < 0 || index > arr.length) {
                    System.out.println("Invalid index!");
                    return;
                }

                for (int i = 0, j = 0; i < newArr.length; i++) {
                    if (i != index) {
                        newArr[j++] = arr[i];
                    } 
                }
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        // Print final array
        System.out.println("\nArray after Deltion:");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}
