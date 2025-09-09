package dp;

import java.util.List;

public class triangle_min_sum {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 动态规划（自底向上）
        int n = triangle.size();
        int[] dp = new int[n]; // 因为每次只变化一行

        // 初始化dp为最后一行的数
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }
        // 从倒数第二行开始网上推
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
