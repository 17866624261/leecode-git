import java.util.Scanner;

public class strIsSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        boolean res = includes(s1,s2);
        System.out.println(res);
    }
    public static boolean includes(String s1,String s2){
        boolean flag = false;
        if (s2.length()>s1.length()){
            return false;
        }
        StringBuilder ss2 = new StringBuilder(s2);
        ss2 = ss2.reverse();
        int pre = 0;
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = pre; j < s1.length(); j++) {
                if (s2.charAt(i)==s1.charAt(j)){
                    pre = j;
                    count++;
                    break;
                }
            }
        }
        if (count==s2.length())
            flag = true;
        count = 0;
        pre = 0;

        for (int i = 0; i < ss2.length(); i++) {
            for (int j = pre; j < s1.length(); j++) {
                if (ss2.charAt(i)==s1.charAt(j)){
                    pre = j;
                    count++;
                    break;
                }
            }
        }
        if (count==s2.length())
            flag = true;


        return flag;
    }
}
