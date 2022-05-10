import java.util.HashSet;
import java.util.Set;

public class Leecode_202 {
    public static void main(String[] args) {
        int n = 2;
        Set<Integer> record = new HashSet<>();
        while((!record.contains(n)) && (n!=1)){
            record.add(n);
            n = calNextNum(n);
        }
        System.out.println(n==1);
    }

    public static int calNextNum(int n) {
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
