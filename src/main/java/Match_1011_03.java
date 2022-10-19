import java.util.HashSet;
import java.util.Scanner;

public class Match_1011_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        sc.nextLine();
        String[] methods = new String[lines];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < lines; i++) {
            methods[i] = sc.nextLine();
        }
        for (int i = 0; i < lines; i++) {
            String[] split = methods[i].split("\\(");
            String mName = split[0].split(" ")[1];
            String[] paras = split[1].substring(0, split[1].length() - 1).split(",");
            StringBuilder sb = new StringBuilder();
            sb.append(mName);
            sb.append("-");
            for (String s : paras) {
                sb.append(s.split(" ")[0]);
            }
            if (set.contains(sb.toString())){
                System.out.println("No");
            }else {
                set.add(sb.toString());
                System.out.println("Yes");
            }
        }
    }
}
