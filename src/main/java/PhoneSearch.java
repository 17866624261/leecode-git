import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result1 {
    public static List<String> findComplement(List<String> PhoneAFeatures, List<String> PhoneBFeatures) {
        List<String> res = new ArrayList<>();
        for (String b : PhoneBFeatures) {
            boolean flag = true;
            for (String a : PhoneAFeatures) {
                if (b.equals(a)) {
                    flag = false;
                }
            }
            if (flag) {
                res.add(b);
            }
        }
        return res;
    }
}
public class PhoneSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        List<String> phoneA = new ArrayList<>();
        List<String> phoneB = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            phoneA.add(sc.nextLine());
        }

        int b = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < b; i++) {
            phoneB.add(sc.nextLine());
        }


        Result1 result = new Result1();
        List<String> res = new ArrayList<>();
        res = result.findComplement(phoneA, phoneB);
        for (String str : res) {
            System.out.println(res);
        }
    }
}


