import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Match_0913_02_01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int subLen = s.length() - 4;
        String[] substrs = new String[subLen];
        for (int i = 0; i < subLen; i++) {
            substrs[i] = s.substring(i,i+5);
        }
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('e',1);
        map.put('i',1);
        map.put('o',1);
        map.put('u',1);
        for (int i = 0; i < substrs.length; i++) {
            String str = substrs[i];
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                if (set.contains(str.charAt(j))){
                    break;
                }else {
                    set.add(str.charAt(j));
                }
            }
            if (map.containsKey(str.charAt(1)) &&
                    map.containsKey(str.charAt(2)) &&
                    map.containsKey(str.charAt(4)) &&
                    (map.getOrDefault(str.charAt(0),0) == 0) &&
                    (map.getOrDefault(str.charAt(3),0) == 0)){
                if (set.size() == 5){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
