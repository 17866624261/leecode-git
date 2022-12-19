public class Match_1101_02 {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        // write code here
        if (nums1.length > m) {
            function(nums1, nums2);
            return nums1;
        } else {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            function(nums1, nums2);
            return nums1;
        }
    }

    public void function(int[] a, int[] b) {
        int i = a.length - 1;
        int ai = a.length - b.length - 1;
        int bi = b.length - 1;
        while (ai >= 0 && bi >= 0) {
            if (a[ai] >= b[bi]) {
                a[i--] = a[ai--];
            } else {
                a[i--] = b[bi--];
            }
        }
        while (ai >= 0) {
            a[i--] = a[ai--];
        }
        while (bi >= 0) {
            a[i--] = b[bi--];
        }
    }
}
