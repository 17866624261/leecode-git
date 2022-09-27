import java.util.Arrays;
import java.util.Collections;

public class Offer_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
//    void quickSort(String[] strs,int left,int right){
//        if (left > right) return;
//        int i = left,j = right;
//        String temp = strs[i];
//        while (i < j){
//
//        }
//    }
}
