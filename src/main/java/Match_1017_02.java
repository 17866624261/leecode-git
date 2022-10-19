import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Match_1017_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int count = map.getOrDefault(str.charAt(i), 0) + 1;
            map.put(str.charAt(i), count);
            if (count >= 2) {
                set.add(str.charAt(i));
            }
        }
        for (Character c : set) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
