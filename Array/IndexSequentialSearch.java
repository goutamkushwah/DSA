import java.util.Scanner;

public class IndexSequentialSearch {

    // Function to perform index sequential search
    public static int indexSequentialSearch(int[] arr, int key) {
        int n = arr.length;
        int blockSize = 3; // Size of each block
        int blocks = (int) Math.ceil((double) n / blockSize);

        // Step 1: Create index table
        int[] index = new int[blocks];
        int[] indexPos = new int[blocks];
        for (int i = 0; i < blocks; i++) {
            int pos = Math.min((i + 1) * blockSize - 1, n - 1);
            index[i] = arr[pos];
            indexPos[i] = i * blockSize;
        }

        // Step 2: Find the block using index table
        int block = -1;
        for (int i = 0; i < blocks; i++) {
            if (key <= index[i]) {
                block = i;
                break;
            }
        }

        // Step 3: If block found, do linear search in that block
        if (block != -1) {
            int start = indexPos[block];
            int end = Math.min(start + blockSize, n);
            for (int i = start; i < end; i++) {
                if (arr[i] == key) {
                    return i; // Element found
                }
            }
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements (space-separated):");
        int key = sc.nextInt(); // Input the key to search

        int result = indexSequentialSearch(arr, key);
        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}
