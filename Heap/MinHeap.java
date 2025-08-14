public class MinHeap{
 // Heapify a subtree rooted with node i (0-based index)
 void heapify(int arr[],int n ,int i){
    int lowest = i ;// Initialize largest as root
    int left = 2*i+1; // left child index
    int right = 2*i+2; // right child index
    // If left child is larger than root
    if(left < n && arr[left] < arr[lowest]){
        lowest = left;
    }
    // If right child is larger than largest so far
    if(right < n && arr[right] < arr[lowest]){
        lowest = right;
    }
    // If largest is not root
    if(lowest != i){
        int temp = arr[i];
        arr[i] = arr[lowest];
        arr[lowest]= temp;
        // Recursively heapify the affected subtree
        heapify(arr, n, lowest);
    }
 }
 // Build a max heap
 void buildHeap(int arr[]){
    int n = arr.length;
    // Index of last non-leaf node
  for(int i=n/2-1;i>=0;i--){
    heapify(arr, n, i);
  }
}
void printHeap(int[] arr){
    for(int num : arr){
        System.out.print(num + " ");
    }
    System.out.println();
}

public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};
        MinHeap heap = new MinHeap();
        heap.buildHeap(arr);
        System.out.print("Min-Heap array: ");
        heap.printHeap(arr);
    }
}
