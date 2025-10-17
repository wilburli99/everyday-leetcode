package regular;

import java.util.HashMap;
import java.util.Map;

public class subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 前缀和+同余
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // 记录余数0在-1位置，初始化

        int preSum = 0;
        int mod;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (k == 0) {
                mod = preSum;
            } else {
                mod = preSum % k;
            }
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
