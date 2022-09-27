import java.util.*;

public class Match_0830_03 {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        char[] colors = sc.next().toCharArray();
//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n-1; i++) {
//            int p = sc.nextInt();
//            int c = sc.nextInt();
//            if (map.containsKey(p)){
//                ArrayList<Integer> list = map.get(p);
//                list.add(c);
//                map.put(p,list);
//            }else {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(c);
//                map.put(p,list);
//            }
//        }
//        int result = 0;
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 2; i < n; i++) {
//            boolean check = check(map,colors,set,i,-1);
//            set.clear();
//            boolean check2 = check(map,colors,set,1,i);
//            set.clear();
//            if (check && check2){
//                result++;
//            }
//        }
//        System.out.println(result);
//    }
//    public static boolean check(HashMap<Integer,ArrayList<Integer>> map,char[] colors,HashSet<Character> set,Integer x,Integer D){
//        if (!map.containsKey(x) || x.equals(D)){
//            if (set.size() >= 3){
//                return true;
//            }
//            return false;
//        }else {
//            boolean flag = false;
//            set.add(colors[x-1]);
//            for (Integer i: map.get(x)) {
//                flag = flag || check(map,colors,set,i,D);
//            }
//            return flag;
//        }
//    }
    public static void main(String[] args) {
        System.out.println("123".valueOf("sting"));


    }
}

//package main
//        import(
//        "bufio"
//        "os"
//        "fmt"
//        "strings"
//        )
//
//        const N = 100010
//        const M = N * 2
//        var h,e,ne [M]int
//        var idx,n,R,G,B int
//        var res int
