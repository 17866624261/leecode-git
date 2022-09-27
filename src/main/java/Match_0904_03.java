import java.lang.reflect.InvocationHandler;
import java.util.*;

public class Match_0904_03 {
    private static LinkedList<Integer> path = new LinkedList();
    private static ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    private static HashMap<Integer,Boolean> haveArr = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int min = 100;
        int[][] weight = new int[n + 1][n + 1];
        int[] m1 = new int[m];
        int[] m2 = new int[m];
        int[] we = new int[m];
        for (int i = 0; i < m; i++) {
            m1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            m2[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            we[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            weight[m1[i]][m2[i]] = we[i];
        }
        backTracking(weight,1,1,0,k,n);
        for (int i = 0; i < allPath.size(); i++) {
            int maxValue = 0;
            ArrayList<Integer> list = allPath.get(i);
            for (int j = 1; j < list.size(); j++) {
                if (weight[list.get(j)][list.get(j-1)] > maxValue){
                    maxValue = weight[list.get(j)][list.get(j-1)];
                }
            }
            if (min > maxValue)
                min = maxValue;
        }
        System.out.println(min);
    }
    public static void backTracking(int[][] weight,int cur,int pre,int sumLen,int k,int n){
        if (weight[pre][cur] == 0 || sumLen > k) return;
        if (cur == n){
            if (sumLen <= k){
                allPath.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (haveArr.getOrDefault(cur,false)){
                continue;
            }else {
                path.add(i);
                sumLen += i - cur;
                haveArr.put(cur,true);
                backTracking(weight,i,cur,sumLen,k,n);
                path.removeLast();
                haveArr.put(cur,false);
            }
        }
    }
}
