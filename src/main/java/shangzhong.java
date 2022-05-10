public class shangzhong {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3,4};
        int[] arr2 = new int[]{3, 4, 5,6};
        int a = 1 / 2;
        System.out.println(a);

        System.out.println(findMedianinTwoSortedAray2(arr1, arr2));
    }

    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int a1 = 0;
        int a2 = 0;
        int medium = 0;
        int flag = 0;

        while (flag < arr1.length) {
            if (arr1[a1] < arr2[a2]) {
                medium = arr1[a1];
                a1++;
                flag++;
            } else if (arr1[a1] > arr2[a2]) {
                medium = arr2[a2];
                a2++;
                flag++;
            } else {
                medium = arr1[a1];
                a1++;
                a2++;
                flag += 2;
            }
        }
        return medium;
    }

    public static int findMedianinTwoSortedAray2(int[] arr1, int[] arr2) {
        int a1 = arr1.length - 1;
        int a2 = 0;
        while (true) {
            if (arr1[a1] > arr2[a2]) {
                a1--;
            } else {
                return arr1[a1];
            }
        }
    }
}


