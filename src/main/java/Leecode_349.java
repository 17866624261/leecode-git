import java.util.HashSet;
import java.util.Set;

public class Leecode_349 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 3, 1};
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                res.add(i);
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for (int i:res) {
            resArr[index++] = i;
        }
    }
}
