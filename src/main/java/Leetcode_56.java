import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] < intervals[i][0]) {
                res.add(new int[]{start, intervals[i - 1][1]});
                start = intervals[i][0];
            } else {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            }
        }
        res.add(new int[]{start, intervals[intervals.length - 1][1]});
        return res.toArray(new int[res.size()][]);
    }
}
