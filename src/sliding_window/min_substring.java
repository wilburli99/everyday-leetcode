package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class min_substring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> tfre = new HashMap<>();
        for (char c : t.toCharArray()) { // 统计t的字符频率
            tfre.put(c, tfre.getOrDefault(c,0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, start = 0;
        int vaild = 0;
        int minlen = Integer.MAX_VALUE;
        while (right < s.length()) { // 开始滑动窗口
            char c = s.charAt(right);
            right++;
            if (tfre.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).intValue() == tfre.get(c).intValue()) {
                    vaild++; // 窗口内的字符频率和t字符串的字符频率相等
                }
            }
            // 收缩窗口，保证最小
            while (vaild == tfre.size()) {
                // 更新最优解
                if (right-left < minlen) {
                    start = left;
                    minlen = right-left;
                }
                char d = s.charAt(left);
                left++;
                if (tfre.containsKey(d)) {
                    if (window.get(d).intValue() == tfre.get(d).intValue()) {
                        vaild--; //如果窗口左边界的字符在t字符串出现,且频率相同,则移除
                    }
                    window.put(d, window.get(d)-1); // 尝试其他最小可能
                }
            }
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start+minlen);
    }
}
