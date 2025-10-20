package regular;

public class find_peek {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > nums[mid + 1]) { // 峰值在左边，包括mid
                right = mid;
            } else { // 峰值在右边，不包括mid
                left = mid + 1;
            }
        }
        return left;
    }
}
