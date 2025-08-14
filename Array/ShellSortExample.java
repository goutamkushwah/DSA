public class ShellSortExample {
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {

            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;
            }
        }
    }

    // Print array method
    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] data = {12, 34, 54, 2, 3};

        System.out.println("Original Array:");
        printArray(data);

        shellSort(data);

        System.out.println("Sorted Array:");
        printArray(data);
    }
}
