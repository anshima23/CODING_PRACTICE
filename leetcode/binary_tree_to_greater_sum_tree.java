

public class binary_tree_to_greater_sum_tree {
     private int cumulativeSum = 0;
    public TreeNode bstToGst(TreeNode root) {
         if (root == null) {
            return null;
        }

        // Reverse in-order traversal: Right -> Node -> Left
       bstToGst(root.right);

        // Update the node's value with the cumulative sum
        cumulativeSum += root.val;
        root.val = cumulativeSum;

        bstToGst(root.left);

        return root;
    }
}
