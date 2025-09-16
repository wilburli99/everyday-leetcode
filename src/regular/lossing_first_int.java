package regular;

public class lossing_first_int {
    public int firstMissingPositive(int[] nums) {
        // 原地哈希
        // 将数组中的数重新排序放到num-1的位置，这样遍历的时候就知道哪个没出现
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        // 再次遍历，找出没有出现的最小正整数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }
}
