import java.util.*;

public class Match_1022_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> sum = new LinkedList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int[] list = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                list[i] = Integer.parseInt(split[i]);
            }
            sum.add(list);
        }
        sc.close();

        // 合并所有重合链表
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < sum.size() - 1; i++) {
                for (int j = i + 1; j < sum.size() - 1; j++) {
                    int[] sumi = sum.get(i);
                    int[] sumj = sum.get(j);
                    if (sumi[sumi.length - 1] > sumj[0]) {
                        // 有重合部分，需要合并
                        int[] newInt = new int[sumi.length + sumj.length];
                        int index = 0;
                        int indexI = 0;
                        int indexJ = 0;
                        while (indexI <= sumi.length - 1 && indexJ <= sumj.length - 1){
                            if (sumi[indexI] < sumj[indexJ]){
                                newInt[index] = sumi[indexI];
                                index++;
                                indexI++;
                            }else {
                                newInt[index] = sumj[indexJ];
                                index++;
                                indexJ++;
                            }
                        }
                        sum.remove(i);
                        sum.remove(j);
                        i = 0;
                        break;
                    }
                }
                flag = true;
            }
        }

        // 判断所有融合后的链表的fib数个数
        int maxCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < sum.size(); i++) {
            int[] cur = sum.get(i);
            int count = 0;
            for (int j = 0; j < cur.length; j++) {
                if (isFib(cur[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }else if (count == maxCount){
                if (sum.get(maxIndex)[0] > cur[0]){
                    maxCount = count;
                    maxIndex = i;
                }
            }
        }
        int[] res = sum.get(maxIndex);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }

    public static boolean isFib(int num) {
        int a = 0, b = 1, n;
        while (b < num) {
            n = a + b;
            a = b;
            b = n;
        }
        if (num == b) return true;
        else return false;
    }
}
