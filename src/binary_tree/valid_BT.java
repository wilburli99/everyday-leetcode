package binary_tree;

public class valid_BT {
    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        // 当前node必须在合理取值范围
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        //      左子树在lower和当前节点的区间内， 右子树在当前节点和upper内
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
