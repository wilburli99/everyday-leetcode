package dp;

import java.util.List;

public class word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 动态规划
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; //空字符串
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // dp[j]是（前面推出的），只需要验证[j,i)
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
