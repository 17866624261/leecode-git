import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Match_0915_01 {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String sa = sc.nextLine();
//        String sb = sc.nextLine();
//        String[] sai = sa.split(",");
//        String[] sbi = sb.split(",");
//        int[] pa = new int[sai.length];
//        int[] pb = new int[sbi.length];
//        for (int i = 0; i < sbi.length; i++) {
//            pa[i] = Integer.valueOf(sai[i]);
//            pb[i] = Integer.valueOf(sbi[i]);
//        }
//        ArrayList<Integer> listA = new ArrayList<>();
//        ArrayList<Integer> listB = new ArrayList<>();
//        int countSum = 0;
//        for (int i = 0; i < sbi.length; i++) {
//            if (pa[i] < pb[i]) {
//                listA.add(pa[i]);
//            } else {
//                listB.add(pb[i]);
//            }
//        }
//        int countA = 0;
//
//        for (int i = 0; i < listA.size(); i++) {
//            countA += listA.get(i);
//        }
//        if (listA.size() >= 3) {
//            countA = countA * (6 / 10);
//        }
//
//        int countB = 0;
//        for (int i = 0; i < listB.size(); i++) {
//            if ((i + 1) % 3 != 0) {
//                countB += listB.get(i);
//            }
//        }
//        countSum = countB + countA;
//        System.out.println(countSum);
//    }
    private static ArrayList<Integer> listA = new ArrayList<>();
    private static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sa = sc.nextLine();
        String sb = sc.nextLine();
        String[] sai = sa.split(",");
        String[] sbi = sb.split(",");
        int[] pa = new int[sai.length];
        int[] pb = new int[sbi.length];
        for (int i = 0; i < sbi.length; i++) {
            pa[i] = Integer.valueOf(sai[i]);
            pb[i] = Integer.valueOf(sbi[i]);
        }
        int[] dp = new int[sbi.length];
        dp[0] = Math.min(pa[0], pb[0]);

        for (int i = 1; i < sbi.length; i++) {
            if (dp[i-1] + aFree(pa[i]) < bFree(dp[i-1],pb[i])){
                listA.add(pa[i]);
                dp[i] = dp[i-1] + aFree(pa[i]);
            }else {
                dp[i] = bFree(dp[i-1],pb[i]);
                listB.add(pb[i]);
                if (listB.size() == 3){
                    listB.clear();
                }
            }
        }
        System.out.println(dp[sai.length - 1]);
    }

    public static int aFree(int pa) {
        if (listA.size() >= 3) {
            return pa * (6 / 10);
        } else {
            return pa;
        }
    }

    public static int bFree(int dpPre, int pb) {
        if (listB.size() >= 2) {
            Collections.sort(listB);
            int minList = listB.get(0);
            if (minList < pb) {
                return dpPre - minList + pb;
            }else {
                return dpPre;
            }
        }
        return dpPre + pb;
    }
}
