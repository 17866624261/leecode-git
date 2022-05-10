import java.util.*;

public class MaxNumList {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Scanner sc2 = new Scanner(line);

        while (sc2.hasNextInt()) {
            nums.add(sc2.nextInt());
        }

        int len = nums.size();
        int[] nu = new int[len];
        nums.forEach(num ->{

        });
        Set<Integer> set = new HashSet<>();
        set.toArray();

        for (int j = 0; j < len; j++) {
            nu[j] = nums.get(j);
        }

        System.out.println(largestNumber(nu));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sx <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });
        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }
}
