import org.junit.Test;

public class Offer_58 {

    @Test
    public void testRe(){
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        swap(chars,0,s.length() - 1);
        int pre = -1;
        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == ' '){
                swap(chars,pre+1,i-1);
                pre = i;
            }
        }
        swap(chars,pre+1,s.length() - 1);
        return new String(chars);
    }
    public void swap(char[] chars,int head,int tail){
        while (head < tail){
            char c = chars[head];
            chars[head] = chars[tail];
            chars[tail] = c;
            head++;
            tail--;
        }
    }
    public String reverseWords2(String s) {
        // 双指针，从后往前找单词放入新的字符串中
        s = s.trim();
        int j = s.length() - 1,i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            while (i>=0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i+1,j+1) + " ");
            while (i>=0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}
