
  // Left skweed tree (left Degenerate tree)
  class Node{
    int data;
    Node right;
    Node(int data){
        this.data = data;
        this.right= null;
    }
}
public class RDegenerateTree {
    Node root;
    // Always insert to the left to create a degenerate tree

    Node insert(Node node,int data){
        if(node == null){
            return new Node(data);
        }
            node.right = insert(node.right, data);
        return node;
    }
    // inoreder traversal 
    void inorder(Node node){
        if(node !=null){
            System.out.print(node.data + " ");
             inorder(node.right);
            
        }
    }
    void preorder(Node node){
        if(node !=null){
            System.out.print(node.data + " ");
            preorder(node.right);
          
        }
    }
    void postorder(Node node){
        if(node !=null){
            postorder(node.right);
           
            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) {
        RDegenerateTree tree = new RDegenerateTree();
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
