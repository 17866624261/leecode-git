import java.util.*;

public class Leetcode_332 {
    LinkedList<String> res = new LinkedList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(t.get(0))) {
                // 有这个出发地
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    public boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(ticketNum)) return true;
                    target.setValue(count);
                    res.removeLast();
                }
            }
        }
        return false;
    }
}
