import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) throws FileNotFoundException {
        int[] nums = {1,2,3,4,5,6,7,9};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        else {
           int mid = (low + high) / 2;
           if (nums[mid] == target) return mid;
           else if (nums[mid] > target) return binarySearch(nums, low, mid - 1, target);
           else return binarySearch(nums, mid + 1, high, target);
        }
    }
}
