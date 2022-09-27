import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Offer_48 {
    public int lengthOfLongestSubstring(String s) {
        // 关键在于找重复的左边界
        int max = 0;
        char[] chars = s.toCharArray();
        int i = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int j = 0; j < chars.length; j++) {
            if (map.containsKey(chars[j])){
                i = Math.max(map.get(chars[j]),i);
            }
            map.put(chars[j],j);
            max = Math.max(max,j-i);
        }
        return max;
    }
}
