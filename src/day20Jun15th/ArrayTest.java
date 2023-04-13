package day20Jun15th;

import java.util.Arrays;

/**
 * @author Rex Joush
 * @time 2022.06.15
 */
public class ArrayTest {



    public void tes() {

    }

    public static void main(String[] args) {
        // 1.数组的定义
        // 1.1 new
        int[] nums = new int[50];
        double[] doubles = new double[50];

        // 50
        int score1 = 20;
        int score2 = 30;
        int score3 = 40;
        int score4 = 50;
        Integer[] scores = new Integer[]{20, 30, 40, 50, 60, 70, 80, 90};
        Arrays.toString(scores);
//        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
//        }

        printArray(scores);

    }

    public static <E> void printArray(E[] myArray) {
        for (E e : myArray) {
            System.out.println(e);
        }
    }

}
