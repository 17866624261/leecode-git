import java.util.HashSet;
import java.util.Set;

public class Match_0821_01 {
    public int lengthOfLongestSubstring(String s) {
        // write code here
        Set<Character> cs = new HashSet<Character>();
        int n = s.length();
        int right = -1, res = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                cs.remove(s.charAt(i - 1));
            }
            while (right + 1 < n && !cs.contains(s.charAt(right + 1))) {
                cs.add(s.charAt(right + 1));
                ++right;
            }
            res = Math.max(res, right - i + 1);
        }
        return res;
    }
}
