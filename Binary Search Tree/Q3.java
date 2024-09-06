import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Q3 {

    public boolean findPair(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> stackLeft = new ArrayDeque<>();
        Deque<TreeNode> stackRight = new ArrayDeque<>();

        TreeNode left = root, right = root;
        while (true) {
            // Traverse left
            while (left != null) {
                stackLeft.push(left);
                left = left.left;
            }
            // Traverse right
            while (right != null) {
                stackRight.push(right);
                right = right.right;
            }

            if (stackLeft.isEmpty() || stackRight.isEmpty() || stackLeft.peek() == stackRight.peek()) {
                break; // Reached the end of traversal or crossed each other
            }

            TreeNode leftNode = stackLeft.peek();
            TreeNode rightNode = stackRight.peek();

            if (leftNode.val + rightNode.val == target) {
                System.out.println("Pair found: (" + leftNode.val + ", " + rightNode.val + ")");
                return true;
            } else if (leftNode.val + rightNode.val < target) {
                // Move left pointer to the right
                left = stackLeft.pop().right;
            } else {
                // Move right pointer to the left
                right = stackRight.pop().left;
            }
        }
        System.out.println("No pair found with the given sum.");
        return false;
    }

    public static void main(String[] args) {
        Q3 solution = new Q3();
        
        // Constructing a sample BST
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        // Finding a pair with a given sum
        int targetSum = 14;
        solution.findPair(root, targetSum);
    }
}
