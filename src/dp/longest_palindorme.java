package dp;

public class longest_palindorme {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int maxlen = 1;
        int start = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true; // 长度为2或3
                    } else {
                        dp[i][j] = dp[i+1][j-1]; // 缩小边界
                    }
                } else {
                    dp[i][j] = false;
                }
                // 更新长度
                if (dp[i][j] && (j-i+1 > maxlen)) {
                    maxlen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }
}
