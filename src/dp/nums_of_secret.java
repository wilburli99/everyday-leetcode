package dp;

public class nums_of_secret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1000000007;
        long[] dp = new long[n+1];
        dp[1] = 1; // 第一天一个人知道
        long share = 0; // 当前可以分享秘密的人数
        for (int day = 2; day <= n; day++) {
            // +， 第day-delay天的人可以分享
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % MOD;
            }
            // -， 第day-forget天的人停止分享
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = share;
        }
        long res = 0;
        // 只统计到n天还记得秘密的人
        for (int i = n - forget + 1; i <= n; i++) {
            res = (res + dp[i]) % MOD;
        }
        return (int)res;
    }
}
