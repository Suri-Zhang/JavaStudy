package day22Sep13th;

/**
 * @author Rex Joush
 * @time 2022.09.13
 */
public class Test {
    private static int guessRow = 0;

    /**
     * The column value previous guessed by the user.
     */
    private static int guessCol = 0;


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 7, 2, 21, 64, 98};
        // -
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "-");
        }
        for (int n : nums) {
            System.out.println(n + "-");
        }
    }

}
