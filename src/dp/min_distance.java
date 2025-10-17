package dp;

public class min_distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // 如果其中一个字符串为空
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 0; i <= n; i++) dp[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]; // 最后一个字符相等
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),
                            dp[i-1][j-1]) + 1; // 最后一个字符不相等，就选择一个操作，增，删，改
                }
            }
        }
        return dp[m][n];
    }
}
