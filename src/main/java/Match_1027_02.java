import java.util.ArrayList;
import java.util.List;

public class Match_1027_02 {
    public int[] flowersFrom(int[] flower,int[][] query){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            int[] curQuery = query[i];
            int needFlo = curQuery[1];
            int left = curQuery[0],right = curQuery[0];
            while (left >= 0 && flower[left] != needFlo){
                left--;
            }
            while (right < flower.length && flower[right] != needFlo){
                right++;
            }
            if (left == -1 && right == flower.length){
                list.add(-1);
            }else if (left == -1){
                list.add(right - curQuery[0]);
            }else if (right == -1){
                list.add(curQuery[0] - left);
            }else {
                list.add(Math.min(right - curQuery[0],curQuery[0] - left));
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
