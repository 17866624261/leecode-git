import org.junit.Test;

public class Match_0908_01 {
    @Test
    public void test(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            sb.append('a');
        }
        for (int i = 0; i < 200; i++) {
            sb.append('b');
        }
        for (int i = 0; i < 200; i++) {
            sb.append('c');
        }
        for (int i = 0; i < 200; i++) {
            sb.append('d');
        }
        for (int i = 0; i < 200; i++) {
            sb.append('e');
        }
        long start = System.currentTimeMillis();
        System.out.println(minOperations(new String(sb)));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public int minOperations (String str) {
        // write code here
        int[] chars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i) - 97] += 1;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            while (chars[i] > 1){
                count++;
                chars[i] -= 2;
                boolean flag = false;
                for (int j = 0; j < 26; j++) {
                    if (chars[j] % 2 == 0){
                        flag = true;
                        chars[j] += 1;
                        break;
                    }
                }
                if (!flag){
                    chars[i] += 1;
                }
            }
        }
        return count;
    }
}
