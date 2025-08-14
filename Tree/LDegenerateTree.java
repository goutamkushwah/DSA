// Left skweed tree (left Degenerate tree)
  class Node{
    int data;
    Node left;
    Node(int data){
        this.data = data;
        this.left= null;
    }
}
public class LDegenerateTree {
    Node root;
    // Always insert to the left to create a degenerate tree

    Node insert(Node node,int data){
        if(node == null){
            return new Node(data);
        }
            node.left = insert(node.left, data);
        return node;
    }
    // inoreder traversal 
    void inorder(Node node){
        if(node !=null){
            inorder(node.left);
            System.out.print(node.data + " ");
            
        }
    }
    void preorder(Node node){
        if(node !=null){
            System.out.print(node.data + " ");
            preorder(node.left);
          
        }
    }
    void postorder(Node node){
        if(node !=null){
            postorder(node.left);
           
            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) {
        LDegenerateTree tree = new LDegenerateTree();
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
  
