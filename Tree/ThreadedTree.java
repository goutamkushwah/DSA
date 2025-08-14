class Node {
    int data;
    Node left, right;
    boolean rightThreaded;
    Node(int data) {
        this.data = data;
        left = right = null;
        rightThreaded = false;
    }
}

public class ThreadedTree {
    Node root;

    // Insert nodes (normal BST insert, for demo)
    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    // Convert BST to threaded tree (inorder threading)
    Node createThreads(Node node, Node prev) {
        if (node == null) {
            return prev;
        }
        prev = createThreads(node.left, prev);
        if (prev != null && prev.right == null) {
            prev.right = node;
            prev.rightThreaded = true; // Mark as threaded
        }
        prev = node;
        return createThreads(node.right, prev);
    }

    // Inorder traversal using threads
    void inorderThreaded(Node root) {
        Node curr = leftMost(root);
        while (curr != null) {
            System.out.print(curr.data + " ");
            if (curr.rightThreaded) {
                curr = curr.right; // Move to the threaded node
            } else {
                curr = leftMost(curr.right); // Move to the leftmost node of the right subtree
            }
        }
    }

    // Preorder traversal (recursive)
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            if (!node.rightThreaded) {
                preorder(node.right);
            }
        }
    }

    // Postorder traversal (recursive)
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            if (!node.rightThreaded) {
                postorder(node.right);
            }
            System.out.print(node.data + " ");
        }
    }

    // Find the leftmost node
    Node leftMost(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        ThreadedTree tree = new ThreadedTree();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 35);

        // Create threads
        tree.createThreads(tree.root, null);

        System.out.print("Inorder Traversal (Threaded): ");
        tree.inorderThreaded(tree.root);
        System.out.println();

        System.out.print("Preorder Traversal: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder Traversal: ");
        tree.postorder(tree.root);
        System.out.println();
    }
}