package day11Jun12th;

import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.06.12
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 转换成数组
        char[] chars = sc.next().toLowerCase().toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left--] != chars[right++]) {
                System.out.println("不是回文");
                return;
            }
        }
        System.out.println("是回文");
    }

}
