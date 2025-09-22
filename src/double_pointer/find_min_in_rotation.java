package double_pointer;

public class find_min_in_rotation {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right-left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // mid偏左
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
