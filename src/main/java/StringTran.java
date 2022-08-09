import java.util.Scanner;

public class StringTran {
    public static void main(String[] args) {
        String s = "a\\sidhsa%\\iuhdiu%a&csd";
        String[] strs = s.split("\\\\",2);
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.replace(0,2,"bcd"));
        System.out.println(s.substring(0,2));
        System.out.println(sb.substring(0,2));
        System.out.println(sb.reverse());
        Scanner sc = new Scanner(System.in);
        double d1,d2;
        d1 = 1.23;
        d2 = 1.23;
        System.out.println(Double.compare(d1,d2));
        for (String str:strs) {
            System.out.println(str);
        }
    }
}
