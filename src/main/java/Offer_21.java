public class Offer_21 {
    public static void main(String[] args) {
        int[] nums = new int[]{11, 9, 3, 7, 16, 4, 2, 0};
        exchange(nums);
        System.out.println(nums);
    }

    public static int[] exchange(int[] nums) {
        int q = 0, o = nums.length - 1;
        while (q < o) {
            // 使用while循环找到两个需要交换的下标
            while (q < o && (nums[q] & 1) == 1) q++;
            while (q < o && (nums[o] & 1) == 0) o--;
            int temp = nums[q];
            nums[q] = nums[o];
            nums[o] = temp;

        }
        return nums;
    }
}
