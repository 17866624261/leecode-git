//import org.springframework.beans.factory.BeanClassLoaderAware;
//import org.springframework.beans.factory.BeanNameAware;
//
//import java.util.Scanner;
//
//public class Match_0913_02_02 implements{
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] t = new int[n];
//        for (int i = 0; i < n; i++) {
//            t[i] = scanner.nextInt();
//        }
//
//        int i = 0;
//        long hp = 0;
//        while (i < n - 2) {
//            int min = Math.min(t[i], Math.min(t[i + 1] / 2, t[i + 2] / 3));
//            t[i] -= min;
//            t[i + 1] -= min * 2;
//            t[i + 2] -= min * 3;
//            i++;
//            hp += 5 * min;
//        }
//        for (int j = 0; j < n; j++) {
//            hp += t[j];
//        }
//        System.out.println(hp);
//    }
//}
