import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int index = -1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a element to search");
        int item = sc.nextInt();
        int mid;
        int left = 0;
        int right = arr.length - 1;
        boolean found = false;
        while(left<=right){
            mid = (left+right)/2;
            if(arr[mid]==item){
                found= true;
                index = mid;
                break;
            }
            else if(arr[mid]<item){
                left= mid+1;

            }
            else{
                right = mid-1;
            }
          
        }
        if(found){
            System.out.println("Element found at index of : "+index);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
