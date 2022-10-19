import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Offer_38 {
    private List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        backTracking(0);
        return res.toArray(new String[res.size()]);
    }
    public void backTracking(int x){
        if (x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        // 每一轮选固定在x位置的字符
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,x);
            backTracking(x+1);
            swap(i,x);
        }
    }
    void swap(int a,int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
