import java.util.*;

public class Match_1017_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        if (n == 0) {
            System.out.println(1);
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String a = str.substring(i, j);
                set.add(a);
            }
        }
        System.out.println(set.size() + 1);
    }
}
