package regular;

public class Roma_to_int {
    public String intToRoman(int num) {
        // 先定义好对应的罗马数字
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            while (num >= vals[i]) {
                num = num - vals[i]; // 减去一个值，就在字符串上加上对应的罗马数字
                res.append(symbol[i]);
            }
        }
        return res.toString();
    }
}
