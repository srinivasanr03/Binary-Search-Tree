class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class q1 {

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null; // Element not found
    }

    public static void main(String[] args) {
        q1 solution = new q1();
        
        // Constructing a sample BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        // Search for elements
        int[] elementsToSearch = {2, 5, 8};
        for (int element : elementsToSearch) {
            TreeNode result = solution.searchBST(root, element);
            if (result != null) {
                System.out.println("Element " + element + " found in the BST.");
            } else {
                System.out.println("Element " + element + " not found in the BST.");
            }
        }
    }
}
