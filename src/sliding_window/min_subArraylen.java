package sliding_window;

public class min_subArraylen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int substr = Integer.MAX_VALUE;
        // 滑动窗口
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                substr = Math.min(substr, right - left + 1);
                sum -= nums[left++];
            }
        }
        return substr == Integer.MAX_VALUE ? 0 : substr; //处理0的情况
    }
}
