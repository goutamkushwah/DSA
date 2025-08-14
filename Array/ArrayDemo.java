
public class ArrayDemo{
    public static void main(String[] args) {
        /*int a[] = new int[5];
        a[0] = 10;
        a[1] = 20;
        */
        int arr[]= {1,2,3,4,5,6};
        // for each loop
       /* for(int ab : arr){
            System.out.println(ab);
        }
             */
        for(int i=0;i<arr.length;i++){
        System.out.println(arr[i]);
    }
 //   methods of array
 // 1 length of array
 System.out.println("Length of array: " + arr.length);
 // 2 array indexing
        System.out.println("Element at index 2: " + arr[2]);
        // 3 array copy
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        System.out.println("Copied array:");
        for (int i = 0; i < arrCopy.length; i++) {
            System.out.print(arrCopy[i] + " ");
        }
        System.out.println();
        //4 updating aray element
        arr[0] = 100;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
    
    }
}