package binary_tree;

public class sum_path3 {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        // 当前节点+左子树+右子树
        return countPath(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    // 从当前节点出发的路径数量
    private int countPath(TreeNode node, long targetSum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == targetSum) count++;
        // 向下继续找
        count += countPath(node.left, targetSum - node.val);
        count += countPath(node.right, targetSum - node.val);
        return count;
    }
}
