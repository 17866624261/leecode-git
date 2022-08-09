import org.junit.Test;

public class Offer_05 {
    @Test
    public void testReplace(){
        String s = " Hello World!";
        replaceBlank(s);
    }
    public void replaceBlank(String s){
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                count++;
            }
        }
        char[] newChars = new char[s.length()+2*count];
        int tail = newChars.length - 1;
        for (int i = s.length() - 1; i >=0 ; i--) {
            if (chars[i] == ' '){
                newChars[tail--] = '0';
                newChars[tail--] = '2';
                newChars[tail--] = '%';
            }else {
                newChars[tail--] = chars[i];
            }
        }
        System.out.println(String.valueOf(newChars));
    }
}
