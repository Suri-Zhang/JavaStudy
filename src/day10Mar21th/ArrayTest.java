package day10Mar21th;


import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.03.21
 */
public class ArrayTest {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 定义数组
        int[] array = new int[10];
        // 0 - 9

        // 数组赋值
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);


//        array[0] = sc.nextInt();
//        array[1] = sc.nextInt();
//        array[2] = sc.nextInt();
//        array[3] = sc.nextInt();
//        array[4] = sc.nextInt();

//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        int d = sc.nextInt();
//        int e = sc.nextInt();
//
//        double[] array2 = new double[10];
//        long[] array3 = new long[10];
//        String[] array4 = new String[10];
//        FunctionTest[] array5 = new FunctionTest[10];
//
////        int sum = a + b + c + d + e;
//        sum = array[0] + array[1] + array[2] + array[3];
//        System.out.println(sum);

    }


    public int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

}
