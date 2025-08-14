public class Trversing {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("Sequential Traversing of an Array");
        System.out.println("Elements of the array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after printing all elements
        System.out.println("Reverse Traversing of an Array");
        for (int i=arr.length-1;i>=0;i--){
            System.out.print( arr[i] + " ");
        }
    }
    
}
