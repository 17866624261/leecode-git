import java.util.HashMap;
import java.util.Map;

public class Offer_50 {
    public char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c:chars) {
            map.put(c,!map.containsKey(c));
        }
        for (char c:chars) {
            if (map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
