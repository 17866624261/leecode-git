import java.util.LinkedList;
import java.util.Scanner;

public class Match_0812_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int haveV = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = new int[n];
        int index = 2;
        int point = 0;
        while (haveV < n-1){
            index = index%n;
            if (res[index] == 0){
                res[index] = arr[point];
                index++;
                while (res[index%n]!=0){
                    index++;
                }
                index++;
                while (res[index%n]!=0){
                    index++;
                }
                index++;
                haveV++;
                point++;
            }else {
                index++;
            }
        }
        res[(index-1)%n] = arr[n-1];
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] +" ");
        }
    }

    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (list.size() > 0){
            int k = 0;
            while (list.size() > 0 && k <2){
                Integer last = res.getLast();
                res.addFirst(last);
                res.removeLast();
                k++;
            }
            res.addFirst(list.pop());
        }
        System.out.println(res);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.pop());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
