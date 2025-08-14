public class Deletion {
    public static void main(String[] args) {
        int arr[] = {5, 2, 9, 1, 5, 6};
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 1. Delete at beginning
        int deleteIndex = 0;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != deleteIndex) {
                newArr[j++] = arr[i];
            }
        }
        System.out.println("After deleting at index " + deleteIndex + ":");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 2. Delete at end
        deleteIndex = arr.length - 1;
        newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != deleteIndex) {
                newArr[j++] = arr[i];
            }
        }
        System.out.println("After deleting at end:");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 3. Delete at specific index
        deleteIndex = 2; // example: delete the element at index 2
        newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != deleteIndex) {
                newArr[j++] = arr[i];
            }
        }
        System.out.println("After deleting at index " + deleteIndex + ":");
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }
}