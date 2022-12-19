package Interview_algorithm;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5, 3, 7, 9, 1};
        selectionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }
}
