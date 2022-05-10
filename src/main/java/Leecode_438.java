import java.util.*;

public class Leecode_438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        int sLen = s.length();
        int pLen = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        List<Integer> res = new ArrayList<>();

        if (p.length() > s.length()) {

        }
        // 初始化双指针指向元素的值
        for (int i = 0; i < pLen; i++) {
            ++sCount[s.charAt(i)-'a'];
            ++pCount[p.charAt(i)-'a'];
        }
        if (Arrays.equals(sCount,pCount)){
            res.add(0);
        }
        for (int i = 0;i < sLen - pLen;i++){
            --sCount[s.charAt(i)-'a'];
            ++sCount[s.charAt(i+pLen)-'a'];
            if (Arrays.equals(sCount,pCount)){
                res.add(i);
            }
        }

    }

    public void method1() {
        Map<String, String> map = new HashMap<>();
        List<Integer> record = new ArrayList<>();
        String s = "abab";
        String p = "ab";
        char[] c = p.toCharArray();
        Arrays.sort(c);
        String key = new String(c);
        map.put(key, p);
        int i = 0, j = p.length() - 1;
        while (i < s.length() && j < s.length()) {
            String sub = s.substring(i, j + 1);
            char[] subC = sub.toCharArray();
            Arrays.sort(subC);
            if (map.containsKey(new String(subC))) {
                record.add(i);
            }
            i++;
            j++;
        }
        System.out.println(record);
    }
}

