import java.util.Arrays;
public class Array_methods {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1};

        Arrays.sort(nums);
        System.out.println("Sorted: " + Arrays.toString(nums)); // [1, 2, 5, 9]

        int[] copy = Arrays.copyOf(nums, 6);
        System.out.println("Copy: " + Arrays.toString(copy)); // [1, 2, 5, 9, 0, 0]

        Arrays.fill(copy, 3);
        System.out.println("Filled: " + Arrays.toString(copy)); // [3, 3, 3, 3, 3, 3]
        int a[]= {1, 2, 3, 4, 5};
        int b[]= {1, 2, 3, 4, 5};
        boolean isEqual = Arrays.equals(a, b);
        System.out.println("Arrays are equal: " + isEqual); // true
        ;
    }
}
