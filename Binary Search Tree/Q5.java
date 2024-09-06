class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Q5 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                // Found the LCA
                return root;
            }
        }

        // If either p or q is not found in the tree
        return null;
    }

    public static void main(String[] args) {
        Q5 solution = new Q5();
        
        // Constructing a sample BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        // Finding the lowest common ancestor
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        if (lca != null) {
            System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("Either " + p.val + " or " + q.val + " is not found in the tree.");
        }
    }
}
