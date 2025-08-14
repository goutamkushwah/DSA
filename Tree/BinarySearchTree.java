
  class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
  }  
  public class BinarySearchTree {
    Node root;
    // insert a new node in the tree (recursive) 
    Node insert(Node node , int data){
        if(node == null){
            return new Node(data);
        }
        if(data < node.data){
            node.left = insert(node.left,data);
        }
        else if(data > node.data){
            node.right = insert(node.right,data);
        }
        return node;
    }
     // inoreder traversal 
    void inorder(Node node){
        if(node !=null){
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
    void preorder(Node node){
        if(node !=null){
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    void postorder(Node node){
        if(node !=null){
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }
      public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);

        System.out.print("Inorder Traversal: ");
        bst.inorder(bst.root); // Output: 20 30 40 50 60 70 80
        System.out.println();
        System.out.print("preorder Traversal: ");
        bst.preorder(bst.root); // Output: 50 30 20 40 70 60 80
        System.out.println();
        System.out.print("postorder Traversal: ");
        bst.postorder(bst.root); // Output: 20 40 30 60 80 70 50
    }
}
