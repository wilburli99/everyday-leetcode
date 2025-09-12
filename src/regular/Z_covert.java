package regular;

public class Z_covert {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || n <= numRows) return s;
        // 构建字符串数组
        StringBuilder[] rows = new StringBuilder[numRows];
        // 初始化每行字符串
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int currow = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            rows[currow].append(c);
            // 判断是否到头,转向
            if (currow == 0 || currow == numRows-1) {
                flag = !flag;
            }
            if (flag) {
                currow += 1;
            } else {
                currow += -1;
            }
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
