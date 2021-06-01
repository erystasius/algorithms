import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {1, 32, 4, 5, 2, 3, 5, 6, 7, 33};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            for (int j = i - 1; j >= 0; j--)
                if (nums[j] > nums[j + 1]) swap(nums, j, j + 1);
    }

    public static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
