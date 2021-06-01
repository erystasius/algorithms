import java.util.Arrays;

public class MergeSortBottomUp {
    static int[] aux = new int[100];

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        mergesort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergesort(int[] nums) {
        for (int i = 2; i < nums.length; i = i * 2) {
           for (int j = 0; j < nums.length / i + 1; j += i) {
              merge(nums, j, j + i / 2 - 1, Math.min(j + i - 1, nums.length - 1)); // 注意此处的 min
           }
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) aux[k] = nums[k];
        for (int k = low; k <= high; k++) {
            if (i > mid) nums[k] = aux[j++];
            else if (j > high) nums[k] = aux[i++];
            else if (aux[i] < aux[j]) nums[k] = aux[i++];
            else nums[k] = aux[j++];
        }
    }
}
