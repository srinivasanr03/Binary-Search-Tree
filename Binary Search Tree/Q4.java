class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Q4 {

    public TreeNode inorderPredecessor(TreeNode root, int key) {
        TreeNode predecessor = null;

        while (root != null) {
            if (root.val < key) {
                // Update predecessor and move to the right subtree
                predecessor = root;
                root = root.right;
            } else {
                // Move to the left subtree
                root = root.left;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {
        Q4 solution = new Q4();
        
        // Constructing a sample BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        // Finding the inorder predecessor
        int key = 7;
        TreeNode predecessor = solution.inorderPredecessor(root, key);
        if (predecessor != null) {
            System.out.println("Inorder predecessor of " + key + " is: " + predecessor.val);
        } else {
            System.out.println("There is no inorder predecessor for the given key in the BST.");
        }
    }
}
