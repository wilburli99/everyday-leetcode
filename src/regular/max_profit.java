package regular;

public class max_profit {
    public int maxProfit(int[] prices) {
        // 允许多次交易，把上升区间相加
        int reward = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                reward += prices[i+1] - prices[i];
            }
        }
        return reward;
    }
}
