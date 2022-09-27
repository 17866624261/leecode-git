import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Offer_04 {

    @Test
    public void testFind() {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find(nums, 7));
    }

    public boolean find(int[][] nums, int target) {
        int row = 0;
        int col = nums[0].length - 1;
        while (row < nums.length && col >= 0) {
            if (nums[row][col] == target) {
                return true;
            } else if (nums[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        List<Integer> strings = Arrays.asList(1,2,3);
        Collections.sort(strings,(o1, o2) -> o1-o2);
        return false;
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >=0){
            if (matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
