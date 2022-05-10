import java.util.*;

public class Leecode_49 {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        String[] strs = new String[]{"", ""};
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        new ArrayList<List<String>>(map.values());
    }
}
