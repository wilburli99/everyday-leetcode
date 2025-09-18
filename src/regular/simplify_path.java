package regular;

import java.util.ArrayDeque;
import java.util.Deque;

public class simplify_path {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String str : strs) {
            if (str.equals("")  || str.equals(".")) {
                continue; // 当前目录
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); // 返回上一级
                }
            } else {
                stack.addLast(str); // 有效目录
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s : stack) {
            res.append("/").append(s);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}
