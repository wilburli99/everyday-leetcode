package dp;

public class max_dulp_sub {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        int maxlen = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1]) { // 如果前面相等,+1
                    dp[i][j] = dp[i-1][j-1] + 1;
                    maxlen = Math.max(maxlen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxlen;
    }
}
