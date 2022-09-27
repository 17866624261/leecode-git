public class Match_0924_01 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,9};
        System.out.println(search(nums,10));
    }
    public static int search(int[] nums,int target){
        if (searchHalf(nums,target,0,nums.length-1)){
            return target;
        }else {
            return -1;
        }
    }
    public static boolean searchHalf(int[] nums ,int target,int start ,int end){
        if (end - start <=1){
            if (nums[start] == target || nums[end] == target){
                return true;
            }else {
                return false;
            }
        }
        int middle = (start + end) / 2;
        return searchHalf(nums,target,start,middle) || searchHalf(nums,target,middle,end);
    }
}
