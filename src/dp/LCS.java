package dp;

public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // dp[i][j]表示text1前i个字符和text2前j个字符的LCS长度
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 如果两字符相等，则加到LCS中作为末尾
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else { // 两字符不相等，则放弃其中一个字符串的字符，取二者最大值
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String text1 = "abcde";
        String text2 = "ace";

        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println("最长公共子序列长度: " + result); // 输出 3
    }
}
