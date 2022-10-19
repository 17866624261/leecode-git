import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Match_1010_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if (map.get(str.charAt(i)) >= 2) {
                set.add(str.charAt(i));
            }
        }
        for (Character c: set) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
