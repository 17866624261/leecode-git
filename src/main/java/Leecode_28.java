public class Leecode_28 {
    public static void main(String[] args) {
        String haystack = "aabaabaafa";
        String needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        // 找第一个匹配下标
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            // 找上一个相等前后缀后的一个元素跟当前主串比较，如果不同再找前一个
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            // 如果相等则子串循环到下一个元素，主串在外层for循环中跳到下一个元素
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            // j从-1开始，如果j等于子串长度减一则可以匹配，这时返回当前循环到的i减去子串长度加1即可
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        // 如果没有找到返回-1
        return -1;
    }

    private static void getNext(int[] next, String s) {
        // 构建next数组，即前缀表
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            // i从1开始，每次的j都是上一轮找到的匹配前后缀串的前缀下一个元素，而i是后缀的下一个元素
            while (j >= 0 && s.charAt(j + 1) != s.charAt(i)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
