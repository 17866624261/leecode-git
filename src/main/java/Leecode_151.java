public class Leecode_151 {
    public static void main(String[] args) {
        String s = "the  sky  is  blue ";

        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {

        // 字符串去掉多余的空格
        StringBuilder sb = removeSpace(s);
        System.out.println(sb);
        s = new String(sb);
        // 字符串整体反转
        char[] ch = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            ch[left] ^= ch[right];
            ch[right] ^= ch[left];
            ch[left] ^= ch[right];
            left++;
            right--;
        }
        // 字符串局部反转
        reverseEachWord(ch);

        return new String(ch);
    }

    private static StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
    }

    private static void reverseEachWord(char[] ch) {
        int start = 0;
        int end = 0;
        while (end < ch.length) {
            while (end < ch.length && ch[end] != ' ') end++;
            int left = start;
            int right = end - 1;
            while (left < right) {
                ch[left] ^= ch[right];
                ch[right] ^= ch[left];
                ch[left] ^= ch[right];
                left++;
                right--;
            }
            start = end;
            start++;
            end++;
        }
    }
}
