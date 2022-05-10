public class Leecode_344 {
    public static void main(String[] args) {

    }
    public static void reverseString(char[] s) {
        for (int i = 0,j = s.length - 1; i < s.length/2; i++,j--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }

    }
}
