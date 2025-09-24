package greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class remove_k_digits {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";
        // 单调栈控制
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && stack.size() > 0 && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        // 如果还有剩余
        while (k > 0 && stack.size() > 0) {
            stack.pollLast();
            k--;
        }
        // 如果前面有0
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            if (res.length() == 0 && c == '0') continue;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
