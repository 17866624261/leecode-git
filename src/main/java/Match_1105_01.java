import java.util.HashSet;

public class Match_1105_01 {
//    public static void main(String[] args) {
//        System.out.println(getSubStringLength("wubaanalyst"));
//    }
    public int getSubStringLength (String s) {
        // write code here
        int max = 0;
        HashSet<Character> set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else {
                    break;
                }
            }
            if (set.size() > max) max = set.size();
            set.clear();
        }
        return max;
    }
}
