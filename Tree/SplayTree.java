class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;   
    }
}

public class SplayTree {
    Node root;

    // Right rotation
    Node rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    } 

    // Left rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Splay operation
    Node splay(Node root , int key){
        if(root == null || root.data == key) {
            return root;
        }
        // key lie in left subtree
        if(key < root.data) {
            if(root.left == null){
                return root; // Key not found 
            }
            // Zig-zig 
            if(key < root.left.data) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            // Zig-zag
            else if(key > root.left.data) {
                root.left.right = splay(root.left.right, key);
                if(root.left.right != null) {
                    root.left = leftRotate(root.left);
                }
            }
            return (root.left == null) ? root : rightRotate(root);
        }
        // key lie in right subtree
        else {
            if(root.right == null){
                return root; // Key not found
            }
            // Zag-zig
            if(key < root.right.data) {
                root.right.left = splay(root.right.left, key);
                if(root.right.left != null) {
                    root.right = rightRotate(root.right);
                }
            }
            // Zag-zag
            else if(key > root.right.data) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    // Insert a node and splay it to root
    Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        root = splay(root, key);
        if (root.data == key) return root; // No duplicates

        Node newNode = new Node(key);
        if (key < root.data) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        return newNode;
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
        // Preorder traversal
void preorder(Node node) {
    if (node != null) {
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
}

// Postorder traversal
void postorder(Node node) {
    if (node != null) {
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
}
    

    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root); // Output: 10 20 30 40 50
       System.out.print("\nPreorder Traversal: ");
       tree.preorder(tree.root);

         System.out.print("\nPostorder Traversal: ");
          tree.postorder(tree.root);
        // Splay 30 to root
        tree.root = tree.splay(tree.root, 30);
        System.out.print("\nAfter splaying 30, root is: " + tree.root.data);

    }
}