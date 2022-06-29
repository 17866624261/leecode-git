import java.util.Arrays;

public class Leetcode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int remove = 0;
        int pre = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (pre > intervals[i][0]) {
                remove++;
                pre = Math.min(pre, intervals[i][1]);
            } else {
                pre = intervals[i][1];
            }
        }
        return remove;
    }
}
