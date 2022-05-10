import java.util.*;

public class Leecode_350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int count = map.getOrDefault(i, 0);
                if (count > 0){
                    res[index++] = i;
                    count--;
                    if (count > 0){
                        map.put(i,count);
                    }else {
                        map.remove(i);
                    }
                }
            }
        }
        System.out.println(Arrays.copyOfRange(res,0,index));
    }
    public void method1(int[] nums1,int[] nums2){
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                int count = map.getOrDefault(i, 0);
                if (count > 0){
                    res.add(i);
                    count--;
                    if (count > 0){
                        map.put(i,count);
                    }else {
                        map.remove(i);
                    }
                }
            }
        }
        int[] resArr = new int[res.size()];
        int index = 0;
        for (int i : res) {
            resArr[index++] = i;
        }
    }
}
