import java.util.Scanner;

public class Match_1010_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str.toUpperCase());
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'A'){
                sb.setCharAt(i,'a');
            }
            if (sb.charAt(i) == 'E'){
                sb.setCharAt(i,'e');
            }
            if (sb.charAt(i) == 'I'){
                sb.setCharAt(i,'i');
            }
            if (sb.charAt(i) == 'O'){
                sb.setCharAt(i,'o');
            }
            if (sb.charAt(i) == 'U'){
                sb.setCharAt(i,'u');
            }
        }
        System.out.println(sb.toString());
    }
}
