package Interview_algorithm;

import java.util.Scanner;

public class Match_1104_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String version1 = sc.next();
        String version2 = sc.next();
        System.out.println(versionCompare(version1, version2));
    }

    public static int versionCompare(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int curflag = v1s.length - v2s.length;
        int length = (v1s.length <= v2s.length ? v1s.length : v2s.length);
        for (int i = 0; i < length; i++) {
            int v1 = Integer.valueOf(v1s[i]);
            int v2 = Integer.valueOf(v2s[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        if (curflag > 0) {
            for (int i = length; i < v1s.length; i++) {
                int v1 = Integer.valueOf(v1s[i]);
                if (v1 == 0) {
                    return 0;
                }
            }
            return 1;
        }
        if (curflag < 0) {
            for (int i = length; i < v2s.length; i++) {
                int v2 = Integer.valueOf(v2s[i]);
                if (v2 == 0) {
                    return 0;
                }
            }
            return -1;
        }
        return 0;
    }
}
