import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
//        String s1,s2;
        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入第一个字符串：");
//        s2 = scanner.next();
//        scanner.nextLine();
//        System.out.println("请输入第二个字符串：");
//        s1 = scanner.nextLine();
//        System.out.println("输入的字符串是："+s1+""+s2);
        while (scanner.hasNext()){
            for (int i = 0; i < 3; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                scanner.nextLine();
                res.add(a+b);
            }
        }
        System.out.println(res.stream().toArray());
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//        /* nextLine()是扫描器执行当前行，并返回跳过的输入信息，特别需要注意！！！
//
//            如果没有该行，则执行第一个in.nextLine()命令时的返回值是int n = in.nextInt()的值*/
//            in.nextLine();
//            HashSet<String> set = new HashSet<String>();
//            for (int i = 0; i < n; i++) {
//                String line =
//
//                        in.nextLine();
//                String[] arr = line.split(" ");
//                for (int j = 0; j < arr.length; j++) {
//                    set.add(arr[j]);
//                }
//            }
//            System.out.println("sum:" + set.size());
//        }
    }
}
