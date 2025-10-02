package binary_tree;

public class invert_tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftroot = invertTree(root.left);
        TreeNode rightroot = invertTree(root.right);
        root.left = rightroot;
        root.right = leftroot;
        return root;
    }
}
