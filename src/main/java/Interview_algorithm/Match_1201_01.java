package Interview_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Match_1201_01 {
    public static void main(String[] args) {
        int[] x = {681,483,548,895,434,822,925,80,521};
        int[] res = answer2(x);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] answer(int[] x) {
        Deque<Integer> stack = new LinkedList<>();
        int xLength = x.length;
        // 第一步
        // 入栈
        if (xLength < 13) {
            for (int i = 0; i < xLength; i++) {
                stack.push(x[i]);
            }
        } else {
            for (int i = 0; i < 13; i++) {
                stack.push(x[i]);
            }
        }
        // 出栈
        if (xLength < 2) {
            for (int i = 0; i < xLength; i++) {
                stack.pop();
            }
        } else {
            for (int i = 0; i < 2; i++) {
                stack.pop();
            }
        }
        // 返回的数组
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        // 第二步
        // 获取下标
        Arrays.sort(res);
        int index = Math.abs(Arrays.binarySearch(res, 79) - 1);
        // 第三步
        // 得到阶乘
        long fac = 1;
        for (int i = 1; i <= index; i++) {
            fac *= i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= fac; i++) {
            if (fac % i == 0) {
                list.add(i);
                count++;
            }
            if (count >= 9) break;
        }
        int[] finalRes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            finalRes[i] = list.get(i);
        }
        return finalRes;
    }
    public static int[] answer2(int[] x)
    {
        int firstRes = 0;
        if(x.length==0)
        {
            firstRes = 6;
        }
        else if(x.length%2 == 0)
        {
            int t =6;
            int right = x.length/2;
            int left = x.length/2-1;
            while (left>=0 && right<x.length&&t>0)
            {
                firstRes+=x[left--];
                firstRes+=x[right++];
                t-=2;
            }
        }
        else
        {
            int t = 6;
            int right = x.length/2+1;
            int left = x.length/2-1;
            firstRes+=x[x.length/2];
            while (left>=0 && right<x.length&&t>0)
            {
                firstRes+=x[left--];
                firstRes+=x[right++];
                t-=2;
            }
        }

        int secondRes = 0;
        firstRes =Math.abs(firstRes);
        if(firstRes<67)
        {
            secondRes = 67;
        }
        else
        {
            secondRes = firstRes;
        }
        while (secondRes>10)
        {
            int temp = secondRes;
            secondRes = 0;
            while (temp!=0){
                int num= temp%10; //获取每一位
                temp=temp/10;  //整数退一位
                secondRes+=num;
            }
        }
        int[] res = new int[15];

        int first = 8;
        res[14] = first;
        for(int i = res.length-2;i>=0;i--)
        {
            res[i] = res[i+1]+secondRes;
        }

        return res;
    }
}
