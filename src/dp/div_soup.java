package dp;

public class div_soup {
    public double soupServings(int n) {
        // 份数向上取整
        int N = (int)Math.ceil(n/25.0);
        if (n >= 4475) return 1.0;
        double[][] dp = new double[N+1][N+1];
        dp[0][0] = 0.5; // a和b同时取完
        for (int i = 1; i <= N; i++) {
            dp[0][i] = 1.0; // a先取完
        }
        for (int i = 1; i <= N; i++) {
            dp[i][0] = 0; // b先取完
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] =
                        (dp[Math.max(0,i-4)][j] +  // A-4，B不变
                                dp[Math.max(0,i-3)][Math.max(0,j-1)] +  // A-3份，B-1份
                                dp[Math.max(0,i-2)][Math.max(0,j-2)] +  // A-2， B-2
                                dp[Math.max(0,i-1)][Math.max(0,j-3)]) / 4.0; // A-1， B-1
            }
        }
        return dp[N][N];
    }
}
