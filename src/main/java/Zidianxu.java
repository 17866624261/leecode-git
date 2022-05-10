public class Zidianxu {
    public static void main(String[] args) {
        String num = "0010";
        System.out.println(maxLexicographical(num));
    }

    public static String maxLexicographical(String num) {

        StringBuilder sb = new StringBuilder(num);

        for (int i = 1; i < num.length(); i++) {
            if ('0' == sb.charAt(i)) {
                sb = sb.replace(i, i + 1, "1");
            }
        }
        num = new String(sb);
        return num;
    }
}
