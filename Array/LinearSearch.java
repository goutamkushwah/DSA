import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        int arr []= {10, 20, 30, 40, 50};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a element to search");
        int iteam = sc.nextInt();
        boolean found =false;
        int index=-1;
        for(int i= 0;i<arr.length;i++){
            if(arr[i]==iteam){
                found = true;
                index = i;
                break;
            }
        }
            if(found == true){
                System.out.println("Element found at index: " + index);
            } else {
                System.out.println("Element not found in the array.");  
            }
        }
    }
    
