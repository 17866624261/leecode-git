public class TestUtil {
    public static void main(String[] args) throws Exception {
        String str = "difg123";
        String newStr = convert(str,3);
        System.out.println(newStr);
    }
    public static String convert(String str,int right) throws Exception{
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>=97&&str.charAt(i)<=122){
                int asc = str.charAt(i)+right;
                if (asc>122){
                    asc = asc%122+96;
                }
                char c = (char) asc;
                newStr.append(c);
            }
        }

        return newStr.toString();
    }
}
