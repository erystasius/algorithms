import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeSumFast {
    public static void main(String[] args) throws FileNotFoundException {
        int n = 1000;
        Scanner scanner = new Scanner(new File("algorithms-scala/in/1Kints.txt"));
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        int res = threeSum(nums);
        System.out.println(res);
    }

    public static int threeSum(int[] nums) {
        QuickSort.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int target = -nums[i] - nums[j];
                int res = BinarySearch.binarySearch(nums, j + 1, nums.length - 1, target);
                if (res != -1) count++;
            }
        }
        return count;
    }

}
