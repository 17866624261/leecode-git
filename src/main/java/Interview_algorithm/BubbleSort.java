package Interview_algorithm;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 9, 1};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次相当于把要求排序的逆序沉到底，所以不用改j的初始条件
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

    }
}
