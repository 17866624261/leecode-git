import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String content = " I am noob "+"from runoob.com.";
        String pattern = ".*+runoob.*";
        String str = "{\"name\":\"spy\",\"id\":\"123456\"}";
        String str1 = "\\d";

        boolean isMatch = Pattern.matches("[+]",content);
        String[] strs = str.split("[+]");
        for(String s : strs){
            System.out.println(s);
        }

        System.out.println();
    }
}
