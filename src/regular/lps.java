package regular;

public class lps {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // 当前最长的相等前后缀

        for (int i = 1; i < n; i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len-1]; // 回退
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return s.substring(0, lps[n-1]); // n-1就是lps的最长相等前后缀长度
    }
}
