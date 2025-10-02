package binary_tree;

public class diameter_of_BT {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        dfs(root);
        return res-1; // 求边数需要节点数-1
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0; // 空节点
        int L = dfs(node.left);
        int R = dfs(node.right);
        res = Math.max(res, L+R+1); // 直径就是两个节点的深度和+当前节点
        return Math.max(L, R) + 1; // 返回该节点为根的子树深度
    }
}
