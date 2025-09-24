package binary_tree;

public class recover_tree {
    TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            if (first == null) first = prev; // 第一个逆序
            second = root; // 第二个
        }
        prev = root;
        inorder(root.right);
    }
}
