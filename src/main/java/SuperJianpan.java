//import java.util.Scanner;
//
//public class  {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//        int m = sc.nextInt();
//        System.out.println(step(str,m));
//    }
//
//    public static int step(String str, int m) {
//        int step = 0;
//        int opt = 0;
//        int ne = 0;
//        int s = m;
//        for (int i = 0; i < str.length() - 1; i++) {
//            char cur = str.charAt(i);
//            char next = str.charAt(i + 1);
//            ne += Math.abs(next - cur);
//        }
//        for (int i = 0; i < str.length() - 1; i++) {
//            char cur = str.charAt(i);
//            char next = str.charAt(i + 1);
//
//            if (Math.abs(next - cur) == 1 && s==m)
//                opt += Math.abs(next - cur);
//            else if (s > 0){
//                opt++;
//                s--;
//            }
//            else
//                opt += Math.abs(next - cur);
//        }
//
//        int min = Math.min(opt, ne);
//        step += str.length() + min;
//
//
//        return step;
//    }
//}
