package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class longest_substring {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int right = -1; // 右边界
        int res = 0;
        for (int i = 0; i < n; i++) { // 左边界
            if (i != 0) {
                set.remove(s.charAt(i-1)); // 移动左边界
            }
            while (right+1<n && !set.contains(s.charAt(right+1))) {
                set.add(s.charAt(right+1));
                right++;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }
}
