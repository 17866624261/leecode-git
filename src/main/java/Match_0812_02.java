import java.util.HashSet;
import java.util.Scanner;

public class Match_0812_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        HashSet<String> set = new HashSet<>();
        set.add(0+"_"+0);
        int w = 0,q =0;
        boolean flag = false;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'W'){
                if (w>0){
                    w--;
                    set.add(w+"_"+q);
                }else {
                    break;
                }
            }else if (c == 'A'){
                if (q>0){
                    q--;
                    set.add(w+"_"+q);
                }else {
                    break;
                }
            }else if (c == 'S'){
                if (w<(m-1)){
                    w++;
                    set.add(w+"_"+q);
                }else {
                    break;
                }
            }else if (c == 'D'){
                if (q<(n-1)){
                    q++;
                    set.add(w+"_"+q);
                }else {
                    break;
                }
            }
            if (set.size() == (n*m)){
                flag = true;
                r = i+1;
                break;
            }
        }
        if (flag){
            System.out.println("Yes");
            System.out.println(r);
        }else {
            System.out.println("No");
            System.out.println((m*n)- set.size());
        }
    }
}
