
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution2 {
    public String s(String token) {
        Map map = new HashMap<>();
        map.put("localDate","2020-09-01");
        map.put("ip","128.0.0.9");
        map.put("method","POST");
        map.put("qunarglobal","asdu2333wuroo");
        map.put("nginx-ip","100.90.98.109");


        token = token.replace(":ip","128.0.0.9");
        token = token.replace(":localDate","128.0.0.9");
        token = token.replace(":method","128.0.0.9");
        token = token.replace(":qunarglobal","128.0.0.9");
        token = token.replace(":nginx-ip","128.0.0.9");

        return token;
    }
}

public class TokenOut {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _token = ":ip - - [:localDate] \":method \":qunarglobal\" [:nginx-ip]\":qunarglobal\"";
//        try {
//            _token = in.nextLine();
//        } catch (Exception e) {
//            _token = null;
//        }


        res = new Solution2().s(_token);
        System.out.println(res);
    }
}


