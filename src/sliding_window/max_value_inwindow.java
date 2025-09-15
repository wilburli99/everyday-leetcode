package sliding_window;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class max_value_inwindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n-k+1];
        // 使用双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 移除窗口外的元素
            if (!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            // 保证队列单调递减，小于当前值的都移除: 一定要用while，用if删不完
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            if (i >= k-1) {
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
