package double_pointer;

public class water {
    public int trap(int[] height) {
        // 双指针
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        while (left < right) {
            // 如果左边界的值小，就以左边界为主
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                    left++;
                }
            } else { // 右边界小，以右边界为主
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                    right--;
                }
            }
        }
        return res;
    }
}
