import java.util.Arrays;

public class Leetcode_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < s.length && pre < g.length; i++) {
            if (s[i] >= g[pre]) {
                count++;
                pre++;
            }
        }
        return count;
    }
}
