class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left= null;
        this.right = null; 
    }
}
public class BinaryTree {
    Node root;
    //Insert a new node in the tree(recursive)
    Node insert(Node node,int data){
        if(node == null){
            return new Node(data);
        }
        if(data <node.data){
            node.left = insert(node.left, data);
        }else if(data > node.data){
            node.right = insert(node.right, data);
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
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("Inorder traversal:");
        tree.inorder(tree.root);
        System.out.println("\nPreorder traversal:");
        tree.preorder(tree.root);
        System.out.println("\nPostorder traversal:");
        tree.postorder(tree.root);

       }
}
