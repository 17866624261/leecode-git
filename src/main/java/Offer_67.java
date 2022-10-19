import org.junit.Test;

public class Offer_67 {
    @Test
    public void test() {
        String str = "-91283472332";
        String str1 = "-2147483648";
//        System.out.println(strToInt(str));

        System.out.println(str.compareTo(str1));
    }

    public int strToInt(String str) {
        StringBuilder sb = new StringBuilder(str.trim());
        StringBuilder res = new StringBuilder();
        int red = 0;
        if (sb.charAt(0) == '+' || sb.charAt(0) == '-' || (sb.charAt(0) >= '0' && sb.charAt(0) <= '9')) {
            res.append(sb.charAt(0));
        } else {
            return 0;
        }
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                res.append(sb.charAt(i));
            } else {
                break;
            }
        }
        String result = new String(res);
        if (res.charAt(0) == '-') {

        }
        return Integer.valueOf(res.toString());
    }

    public int strToInt2(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        int res = 0, binary = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;
        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            if (res > binary || res == binary && c[j] >'7') return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return res * sign;
    }
}
