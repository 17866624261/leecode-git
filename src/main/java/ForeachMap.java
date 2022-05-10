
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForeachMap {
    public static void main(String[] args) {
        // 遍历map的写法
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.entrySet().forEach(
                longProductInfoEntry->list.add(String.valueOf(longProductInfoEntry.getValue()))
        );
    }
}
