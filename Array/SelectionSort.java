public class SelectionSort {
    public static void main(String[] args) {
       int arr [] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length - 1; i++) {
        int min =i;
        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[min]){
                min = j;
            }
            
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

            
            System.out.println("Sorted Array:");
            for (int i : arr) {
                System.out.print(i + " ");
            }
}
}