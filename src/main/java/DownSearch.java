import java.util.HashSet;
import java.util.Set;

public class DownSearch {
    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<>();
        int[] char_list={32,39,45,33,34,35,36,37,38,40,41,42,44,46,47,58,59,63,64,91,92,10,9,93,95,96,123,124,125,126,43,60,61,
        62,215,247,48,49,50,51,52,53,54,55,56,57,97,65,98,66,99,67,100,68};
        for (int i = 0; i < char_list.length; i++) {
            sets.add(char_list[i]);
        }


    }
}
