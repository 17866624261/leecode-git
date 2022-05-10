public class Leecode_383 {
    public static void main(String[] args) {
        String s = "aa";
        String t = "ab";
        int[] record = new int[26];
        for (char c: s.toCharArray()) {
            record[c-'a'] -= 1;
        }
        for (char c: t.toCharArray()) {
            record[c-'a'] += 1;
        }
        for (int i: record) {
            if (i<0){
            }
        }
    }
}
