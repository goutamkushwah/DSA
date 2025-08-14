public class TreeSort {
  // BST Node class
  static class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
  }  
  // Insert into BST
  Node insert(Node root , int data){
  if(root == null) {
      return new Node(data);
    }
    if(data < root.data) {
      root.left = insert(root.left, data);
    } else if(data > root.data) {
      root.right = insert(root.right, data);
    }
    return root;
  }
    // Inorder traversal to get sorted elements
    void inorder(Node root, int[] arr, int[] index) {
        if (root != null) {
            inorder(root.left, arr, index);
            arr[index[0]++] = root.data;
            inorder(root.right, arr, index);
        }
    }
    // Tree Sort function
    void treeSort(int[] arr) {
        Node root = null;
        for (int num : arr) {
            root = insert(root, num);
        }
        int[] idx = {0};
        inorder(root, arr, idx);
    }
    public static void main(String[] args) {
    int[] arr = {5, 2, 8, 1, 3};
        
        System.out.print("Original array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        TreeSort ts = new TreeSort();
        ts.treeSort(arr);
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }    
    }
}
