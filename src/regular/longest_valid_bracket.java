package regular;

import java.util.ArrayDeque;
import java.util.Deque;

public class longest_valid_bracket {
    public int longestValidParentheses(String s) {
        // 用栈来记录当前括号的位置
        int n = s.length();
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // 先放入一个无效的位置
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // 将当前的‘)’的位置作为新的无效位置
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
