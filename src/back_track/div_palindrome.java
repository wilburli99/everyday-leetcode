package back_track;

import java.util.ArrayList;
import java.util.List;

public class div_palindrome {
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }
    private void backTrack(String s, int start) {
        // 结束条件，起始位置达到末尾，说明找到一种分割方法
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int end = s.length()-1;
        for (int i = start; i <= end; i++) {
            if (isPalindrome(s, start, i)) {
                cur.add(s.substring(start, i+1)); // 符合条件，选择，左闭右开i+1
                backTrack(s, i+1); // 递归
                cur.remove(cur.size()-1); // 回溯
            }
        }
    }
    // 判断是否回文
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
