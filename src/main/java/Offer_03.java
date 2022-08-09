import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Offer_03 {
    @Test
    public void testDup() {
        int[] num = new int[]{1, 2, 3, 4, 5, 2};
        System.out.println(duplicate2(num));
    }

    public int duplicate(int[] num) {
        int[] hash = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            if (hash[num[i]] != 0) {
                return num[i];
            } else {
                hash[num[i]] += 1;
            }
        }
        return -1;
    }

    public int duplicate2(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                return num[i];
            } else {
                map.put(num[i],1);
            }
        }
        return -1;
    }
}
