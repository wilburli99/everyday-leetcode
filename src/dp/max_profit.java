package dp;

public class max_profit {
    public int maxProfit(int[] prices) {
        // 动态规划
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 第一天不买入
        dp[0][1] = -prices[0]; //第一天买入，亏钱状态
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
