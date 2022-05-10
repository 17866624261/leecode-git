public class Leecode_offer58 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseLeftWords(s, 2));
    }

    public static String reverseLeftWords(String s, int n) {
        char[] ch = s.toCharArray();
        // 整体翻转
        reverseWord(ch, 0, s.length() - 1);
        // 翻转左边部分
        reverseWord(ch, 0, s.length() - n - 1);
        // 翻转右边部分
        reverseWord(ch, s.length() - n, s.length() - 1);
        return new String(ch);
    }

    private static void reverseWord(char[] ch, int left, int right) {
        while (left < right) {
            ch[left] ^= ch[right];
            ch[right] ^= ch[left];
            ch[left] ^= ch[right];
            left++;
            right--;
        }
    }
}
