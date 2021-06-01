import java.util.Arrays;

public class MergeSortTopDown {
    static int[] aux = new int[100];

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
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
