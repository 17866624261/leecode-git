import java.util.*;

public class Match_1111_02 {
    public static void main(String[] args) {
        String[] orders = {"acbabd", "abadac", "acaba"};
        System.out.println(commonProduct(orders));
    }

//    public static String commonProduct(String[] orders) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        List<Character> list = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < orders[0].length(); i++) {
//            map.put(orders[0].charAt(i), map.getOrDefault(orders[0].charAt(i), 0) + 1);
//        }
//        for (int i = 1; i < orders.length; i++) {
//            String order = orders[i];
//            HashMap<Character, Integer> curMap = new HashMap<>();
//            for (int j = 0; j < order.length(); j++) {
//                curMap.put(order.charAt(j), curMap.getOrDefault(order.charAt(j), 0) + 1);
//            }
//            for (Map.Entry set : map.entrySet()) {
//                Character curKey = (Character) set.getKey();
//                if (curMap.containsKey(curKey)) {
//                    map.put(curKey, curMap.get(curKey) < map.get(curKey) ? curMap.get(curKey) : map.get(curKey));
//                } else {
//                    map.remove(curKey);
//                }
//            }
//        }
//        for (Map.Entry set : map.entrySet()) {
//            for (int i = 0; i < (int) set.getValue(); i++) {
//                list.add((Character) set.getKey());
//            }
//        }
//        Collections.sort(list);
//        list.forEach((a) -> sb.append(a));
//        return sb.toString();
//    }
    public static String commonProduct(String[] orders) {
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orders[0].length(); i++) {
            map[orders[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < orders.length; i++) {
            String cur = orders[i];
            int[] curMap = new int[26];
            for (int j = 0; j < cur.length(); j++) {
                curMap[cur.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                map[j] = Math.min(curMap[j], map[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                for (int j = 0; j < map[i]; j++) {
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }
}
