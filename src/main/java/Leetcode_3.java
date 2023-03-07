import java.util.HashSet;
import java.util.Set;

public class Leetcode_3 {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        Set<Character> hashSet = new HashSet<>();
        int pre = -1;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 每轮表示此轮的最长字符，如果一轮结束的时候i还是0，那么表示从0到length是一个无重复字符串
                hashSet.remove(s.charAt(i - 1));
            }
            while (pre + 1 < s.length() && !hashSet.contains(s.charAt(pre + 1))) {
                hashSet.add(s.charAt(pre + 1));
                pre++;
            }
            length = Math.max(length, pre + 1 - i);
        }
        return length;
    }
}
