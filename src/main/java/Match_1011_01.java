import java.util.Scanner;

public class Match_1011_01 {
    public static void main(String [] args){
        Scanner sca = new Scanner(System.in);
        String str1 = sca.next();
        String str2 = "Baidu";
        System.out.println(strSame(str1, str2));
    }

    public static Boolean strSame(String str1, String str2){
        int len2 = str2.length();
        for (int i = 0; i < len2; i++){
            if (str1.indexOf(str2.charAt(i)) < 0)
                return false;
        }
        return true;
    }
}
