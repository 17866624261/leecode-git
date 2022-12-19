public class Match_1021_01 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,1};
        System.out.println(getMaxValue(nums));
    }

    public static int getMaxValue(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return nums[middle];
            } else if (nums[middle] < nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
