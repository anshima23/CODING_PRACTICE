import java.util.ArrayList;
import java.util.List;

public class balance_bst {
     public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        // Step 1: Perform in-order traversal to get sorted nodes
        inorderTraversal(root, nodes);
        
        // Step 2: Construct a balanced BST from the sorted nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorderTraversal(root.left, nodes);
        nodes.add(root.val);
        inorderTraversal(root.right, nodes);
    }
    
    private TreeNode buildBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);
        return root;
    }

    // Method to print the tree (in-order traversal)
    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }
    
}
