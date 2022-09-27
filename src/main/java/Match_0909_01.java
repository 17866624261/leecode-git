import org.junit.Test;

import java.util.HashMap;

public class Match_0909_01 {
    @Test
    public void test(){
        System.out.println(maxCount("rrdd"));
    }

    public int maxCount(String str){
        int[] nums = new int[3];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'r'){
                nums[0] += 1;
            }else if (str.charAt(i) == 'e'){
                nums[1] += 1;
            }else {
                nums[2] += 1;
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 1; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (sb.charAt(i-1) == c){
                count++;
                i++;
            }
        }
        return count;
    }
}
