import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        int left = 1,right = 2,sum = 3;
        List<int[]> res = new ArrayList<>();
        while (left < right){
            if (sum == target){
                int[] a = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    a[i-left] = i;
                }
                res.add(a);
            }
            if (sum >= target){
                sum -= left;
                left++;
            }else {
                right++;
                sum += right;
            }
        }
        return res.toArray(new int[0][]);
    }
}
