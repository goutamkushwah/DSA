public class Insertion {
    public static void main(String[] args) {
     int arr[] = {5, 2, 9, 1, 5, 6};
     System.out.println("Original Array:");

     for(int i: arr) {
         System.out.print(i + " ");
     }
        System.out.println();
     // 1 add at beginning
     int insertIndex = 0;
int newValue = 99;
int[] newArr = new int[arr.length + 1];
for (int i = 0, j = 0; i < newArr.length; i++) {
    if (i == insertIndex) {
        newArr[i] = newValue;
    } else {
        newArr[i] = arr[j++];
    }
}
        System.out.println("After adding " + newValue + " at index " + insertIndex + ":");
        for(int i: newArr) {
            System.out.print(i + " ");
        }
     // 2 add at end
     System.out.println();
     newValue=77;
        newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        //last postion
        newArr[newArr.length - 1] = newValue; // example value
        System.out.println("Array after adding at end:"+newValue);
        for (int i : newArr) {
            System.out.print(i + " ");
        }
        System.out.println();
        // 3 add at specific index

 insertIndex = 5;
 newValue = 88;
 System.out.println();
//int[] newArr = new int[arr.length + 1];
for (int i = 0, j = 0; i < newArr.length; i++) {
    if (i == insertIndex) {
        newArr[i] = newValue;
    } else {
        newArr[i] = arr[j++];
    }
}
        System.out.println("After adding " + newValue + " at index " + insertIndex + ":");
        for(int i: newArr) {
            System.out.print(i + " ");
        }
    }
}