package binary_tree;

public class max_pathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftlen = Math.max(0, dfs(node.left)); // 遇到负数舍弃
        int rightlen = Math.max(0, dfs(node.right));

        int curSum = node.val + leftlen + rightlen; // 当前节点路径的和
        maxSum = Math.max(curSum, maxSum); // 全局最大路径和

        return node.val + Math.max(leftlen, rightlen);
    }
}
