public class Match_1020_01 {

    public int getMaxValue(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
