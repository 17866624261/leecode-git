import java.util.*;

public class Match_0827_01 {
    public static void main(String[] args) {
//        System.out.println(canConvert("hello","helloo"));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ss  = new String[n];
        String[] ts = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.nextLine();
            ts[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if (canConvert(ss[i],ts[i])){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    public static boolean canConvert(String s,String t){
        if (s == null || t == null){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (char c:sChar) {
            map.put(c,map.containsKey(c)?map.get(c)+1:1);
        }
        for (char c:tChar) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)-1);
            }else {
                return false;
            }
        }
        for (Map.Entry entry:map.entrySet()) {
            if (Integer.valueOf(entry.getValue().toString()) > 0){
                return false;
            }
        }
        return true;
    }
}
