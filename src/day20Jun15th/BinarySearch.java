package day20Jun15th;

import java.util.Arrays;

/**
 * @author Rex Joush
 * @time 2022.06.17
 */
public class BinarySearch {

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            nums[i] = (int) (Math.random() * 99 + 1);
//        }
//
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));

        // 22 5
        int mid = 4;
        //                    left         mid                     right
        int[] nums = new int[]{13, 22, 25, 28, 32, 50, 60, 66, 87, 95};
        System.out.println(binarySearch(nums, 95));

    }

    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int secSearch(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

        }

        return -1;
    }

}
