public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    for (int i = 0; i < arr.length; i++) {
        int key = arr[i];
        int j=i-1;
        // Move elements of arr[0..i-1], that are greater than key,
        // to one position ahead of their current position
        while(j>=0&&arr[j]>key){
            arr[j+1]=arr[j];
            j--;
        }
        arr[j+1]=key;
    }
        
        System.out.println("\nSorted Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}        
       