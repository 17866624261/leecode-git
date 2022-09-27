public class Offer_53 {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] <= target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2;
            if (nums[middle] < target) {
                i = middle + 1;
            } else {
                j = middle - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }
    public int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int middle = (left+right) / 2;
            if (nums[middle] == middle){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }
}
