public class leecode_242 {
    public static void main(String[] args) {
        int[] record = new int[26];
        String s = "";
        String t = "";
        for (char c : s.toCharArray()) {
            record[c-'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c-'a'] -= 1;
        }
        for (int i: record) {
            if (i!=0){
            }
        }
    }
}
