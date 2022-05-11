public class Leecode_459 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int len = s.length();
        getNext(next, s);
        if ((next[len - 1] != -1) && (len % (len - (next[len - 1] + 1)) == 0)) {
            return true;
        }
        return false;
    }

    private static void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            // 如果不相等则回溯
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1) ) {
                j = next[j];
            }
            // 如果相等则直接填入next数组
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
