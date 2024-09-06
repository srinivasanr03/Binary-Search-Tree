class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class q2 {

    private int count = 0;
    private int result = -1;

    public int kthLargest(TreeNode root, int k) {
        count = 0; // Reset count before each call
        result = -1; // Reset result before each call
        reverseInOrder(root, k);
        return result;
    }

    private void reverseInOrder(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }
        // Traverse right subtree
        reverseInOrder(root.right, k);
        
        // Process current node
        count++;
        if (count == k) {
            result = root.val; // Found the k'th largest node
            return;
        }
        
        // Traverse left subtree
        reverseInOrder(root.left, k);
    }

    public static void main(String[] args) {
        q2 solution = new q2();
        
        // Constructing a sample BST
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);

        // Finding the k'th largest node
        int k = 2;
        int kthLargest = solution.kthLargest(root, k);
        if (kthLargest != -1) {
            System.out.println("The " + k + "'th largest node in the BST is: " + kthLargest);
        } else {
            System.out.println("Invalid value of k or BST does not have enough nodes.");
        }
    }
}
