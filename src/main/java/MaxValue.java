//public class Solution {
//    public  String solve(int[] nums)
//    {
//        for(int i = 0;i<nums.length-1;i++)
//        {
//            for (int j = 0; j < nums.length - 1 - i; j++)
//            {
//                String temp1 = function(nums);
//
//                int x = nums[j];
//                nums[j] = nums[j + 1];
//                nums[j + 1] = x;
//                String temp2 = function(nums);
//                if(temp1.compareTo(temp2)>0)
//                {
//                    x = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = x;
//                }
//
//            }
//        }
//        return function(nums);
//    }
//    public  String function(int[] nums)
//    {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int num : nums) {
//            stringBuilder.append(num);
//        }
//        return stringBuilder.toString();
//    }
//}
