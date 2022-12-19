import java.util.HashMap;
import java.util.Scanner;

public class Match_1026_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            end[i] = sc.nextInt();
            map.put(end[i], i);
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (map.get(start[i]) < map.get(start[j])){
                    res++;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}
