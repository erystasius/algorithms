import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = partition(arr, low, high);
        quicksort(arr, low, pivot - 1);
        quicksort(arr, pivot + 1, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pival = arr[low];
        int i = low + 1;
        int j = high;
        do {
            while (arr[i] <= pival && i < high) i++; // first element that > pival or the rightmost element
            while (arr[j] >  pival && i <= j)   j--;// first element that <= pival, could be the leftmost
            if (i < j) swap(arr, i, j);
        } while (i < j); // when it stops, all element right to j is greater than pival
        swap(arr, low, j); // j is the rightmost of left subarray where all elements are less or equal to pival
        return j;
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
