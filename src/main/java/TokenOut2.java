import java.util.Scanner;

class Solution {
    public String gets(String token) {
        StringBuilder stringBuilder = new StringBuilder(token);
        String[] x = {"nginx-ip","localDate","ip","method","qunarglobal"};
        String[] replace = {"100.90.98.109","2020-09-01","128.0.0.9","POST","asdu2333wuroo"};
        for(int i = 0;i<x.length;i++)
        {
            while (stringBuilder.indexOf(x[i])!=-1)
            {
                int index = stringBuilder.indexOf(x[i]);
                stringBuilder.delete(index-1,index+x[i].length());
                stringBuilder.insert(index-1,replace[i]);
            }
        }
        return stringBuilder.toString();
    }
}

public class TokenOut2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _token;
        try {
            _token = in.nextLine();
        } catch (Exception e) {
            _token = null;
        }

        res = new Solution().gets(_token);
        System.out.println(res);
    }
}
