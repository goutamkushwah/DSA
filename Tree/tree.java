import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    List<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class Tree {
    TreeNode root;

    // Add child to a node
    void addChild(TreeNode parent, int childData) {
        TreeNode child = new TreeNode(childData);
        parent.children.add(child);
    }

    // Display tree (preorder traversal)
    void display(TreeNode node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.data);
        for (TreeNode child : node.children) {
            display(child, indent + "  ");
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(1);

        tree.addChild(tree.root, 2);
        tree.addChild(tree.root, 3);
        tree.addChild(tree.root, 4);

        // Add children to node 2
        tree.addChild(tree.root.children.get(0), 5);
        tree.addChild(tree.root.children.get(0), 6);

        // Add child to node 3
        tree.addChild(tree.root.children.get(1), 7);

        // Display tree
        tree.display(tree.root, "");
    }
}