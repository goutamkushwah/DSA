import java.util.Scanner;

public class InterpolationSearch {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60, 70};
        boolean found = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key to search:");
        int key = sc.nextInt(); // Input the key to search
        int low =0;
        int high = arr.length - 1;
        while(low <= high && key >= arr[low] &&key<= arr[high]) {
           int pos = low + ((key - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == key) {
                found= true;
                System.out.println("Element found at index: " + pos);
                return;
            } else if (arr[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
           
        }
        if(found == false) {
            System.out.println("Element not found.");
        }
    }
}

      

    