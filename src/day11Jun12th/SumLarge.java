package day11Jun12th;

import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.06.12
 */
public class SumLarge {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 标记值
        System.out.println("please input an int");
        int value = 0;
        while (true) {
            String s = sc.next();
            if (isInt(s)) {
                value = Integer.parseInt(s);
                break;
            } else {
                System.out.println("invalid int, try again");
            }
        }
        int count = 0;
        int result = 0;
        while (true) {
            System.out.println("please input an another int");

            String s = sc.next();
            if (isInt(s)) {
                int another = Integer.parseInt(s);
                if (another == 0) {
                    break;
                }
                if (another > value) {
                    count++;
                    result += another;
                }
            }
            else {
                System.out.println("invalid int");
            }
        }
        System.out.println("count: " + count);
        System.out.println("sum: " + result);
    }

    // 判断是否是数字字符串
    private static boolean isInt(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            if (c < '0' || c > '9') {
//            if (!(c >= '0' || c <= '9')) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

}
