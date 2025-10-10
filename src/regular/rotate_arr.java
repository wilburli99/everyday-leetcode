package regular;

public class rotate_arr {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            // 将除了后k位的数移到新数组的后k-1位，使用模运算 % n 处理越界情况
            res[(i + k) % n] = nums[i];
        }
        //
        System.arraycopy(res, 0, nums, 0, n);
    }
}
