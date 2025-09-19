package regular;

public class check_ip_address {
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) return "IPv4";
        if (isIPv6(queryIP)) return "IPv6";
        return "Neither";
    }
    private boolean isIPv4(String queryIP) {
        String[] parts = queryIP.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String s : parts) {
            if (s.length() == 0 || s.length() > 3) return false;
            if (s.charAt(0) == '0' && s.length() != 1) return false;
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            int num = Integer.parseInt(s);
            if (num > 255) return false;
        }
        return true;
    }
    private boolean isIPv6(String queryIP) {
        String[] parts = queryIP.split(":", -1);
        if (parts.length != 8) return false;
        String symbol = "0123456789abcdefABCDEF";
        for (String s : parts) {
            if (s.length() < 1 || s.length() > 4) return false;
            for (char c : s.toCharArray()) {
                if (symbol.indexOf(c) == -1) return false; // 是否存在16进制中的字符
            }
        }
        return true;
    }
}
