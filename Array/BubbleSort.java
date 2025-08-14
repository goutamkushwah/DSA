public class BubbleSort {
    public static void main(String[] args) {
        int arr [] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Array:");
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j=0;j<arr.length-1;j++){
        for (int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                int trmp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=trmp;
            }
            else{
                continue;
            }
            }
        }
            System.out.println("Sorted Array:");
            for (int i: arr) {
                System.out.print(i + " ");
            }
    }
}
