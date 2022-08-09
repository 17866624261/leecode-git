import org.junit.Test;

public class QuickSortTran {
    @Test
    public void testQuick() {
        int[] arr = {4, 3, 2, 6, 1, 9, 19, 2, 17};
        for (int i:quickSort(arr, 0, arr.length - 1)) {
            System.out.print(i+" ");
        }
    }

    public int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr,pivot,index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
