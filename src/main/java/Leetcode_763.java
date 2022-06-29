import java.util.ArrayList;
import java.util.List;

public class Leetcode_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int right = 0;
        int left = -1;
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, edge[chars[i] - 'a']);
            if (right == i) {
                list.add(i - left);
                left = i;
            }
        }
        return list;
    }
}
