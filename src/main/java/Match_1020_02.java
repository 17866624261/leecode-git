import java.util.ArrayList;
import java.util.List;

public class Match_1020_02 {
    public int[] rewrite(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                list.add(i, 0);
                i++;
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
