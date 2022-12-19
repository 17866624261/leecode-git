import java.util.Scanner;

public class Match_1108_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 1;
        while (right < strs.length) {
            if (strs[left].equalsIgnoreCase(strs[right])) {
                right++;
            } else {
                sb.append(strs[left]).append(" ");
                left = right;
                right++;
            }
        }
        if (left < strs.length) {
            sb.append(strs[left]);
        }
        System.out.println(sb);
    }
}
