package dp;

public class inter_leave {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m+n != s3.length()) return false;
        // dp[i][j]表示s1的前i个字符和s2的前j个字符是否能组成s3的前i+j个
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        // 其中一个为空
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
        }
        // 其他情况
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ||
                        dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        return dp[m][n];
    }
}
