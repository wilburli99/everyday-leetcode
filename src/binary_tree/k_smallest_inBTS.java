package binary_tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class k_smallest_inBTS {
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历整个二叉搜素树，找到前k个
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left; // 优先压入左子树，因为左边比较小
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
