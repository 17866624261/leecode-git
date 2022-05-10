public class Leecode_541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2 * k) {
            int left = i;
            int right = Math.min(ch.length - 1, left + k - 1);
            while (left < right){
                ch[left] ^= ch[right];
                ch[right] ^= ch[left];
                ch[left] ^= ch[right];
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}
