import java.util.HashMap;

public class Dynamic {
    private static HashMap<Integer,Integer> map = new HashMap<>();
    private static int[] arrays = {1,5,2,4,3};

    public static int search(int i){
        if (i==arrays.length-1)
            return 1;
        int max_len = 1;
        for (int j = i+1; j < arrays.length; j++) {
            if (arrays[j]>arrays[i])
                max_len = Math.max(max_len,search(j)+1);
        }
        return max_len;
    }
}
