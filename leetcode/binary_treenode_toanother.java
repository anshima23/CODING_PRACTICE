public class binary_treenode_toanother {
    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {return root;}
            
        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);
        
        if (left != null && right != null) { return root;}
        return left != null ? left : right;
    }
    
    private boolean getPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) { return false;}
        if (root.val == target) { return true;}
        path.append('L');
        if (getPath(root.left, target, path)) { return true;}
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (getPath(root.right, target, path)) { return true;}
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
    
        TreeNode lca = findLCA(root, startValue, destValue);
        
        StringBuilder pathToStart = new StringBuilder();
        getPath(lca, startValue, pathToStart);
        
        StringBuilder pathToDest = new StringBuilder();
        getPath(lca, destValue, pathToDest);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < pathToStart.length(); i++) { result.append('U');}
        result.append(pathToDest);   
        return result.toString();
    }
}
