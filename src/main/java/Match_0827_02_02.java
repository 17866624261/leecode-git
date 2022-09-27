import java.util.HashMap;
import java.util.Scanner;

public class Match_0827_02_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> mapJ = new HashMap<>();
        HashMap<Integer, Integer> mapO = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (i % 2 == 1) {
                Integer orDefault = mapJ.getOrDefault(c, 0);
                mapJ.put(c, orDefault + 1);
            } else {
                Integer orDefault = mapO.getOrDefault(c, 0);
                mapO.put(c, orDefault + 1);
            }
        }
        int maxJ = 0;
        int maxO = 0;
        for (Integer value : mapJ.values()) {
            maxJ = Math.max(value, maxJ);
        }
        for (Integer value : mapO.values()) {
            maxO = Math.max(maxO,value);
        }
        int J = 0;
        int O = 0;
        if (n % 2 == 0) {
            J = O = n / 2;
        } else {
            J = n / 2 + 1;
            O = n / 2;
        }
        int result = J - maxJ + O - maxO;
        System.out.println(result);
    }
}
