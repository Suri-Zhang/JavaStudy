 package day08Mar15th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.03.15
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().a(8));

    }

    public String switchXO(String str) {

        //       OX
//        st  = "OXXOXOXOXO";


        int[] integers = new int[10];
        // 0  1  2  3  4  5  6  7  8  9
        // 2  9 11 12 54 14  4 13  4  6
        int _12 = integers[3];
        int four = integers[2];

//        str = "XOOXOX";
        String result = "";
        for (int i = 0; i < 6; i++) {
            char ch = str.charAt(i);
            if (ch == 'X') {
                result += 'O';
            } else {
                result += 'X';
            }
        }
        return result;

    }

    public int a (int num) {
        return (int) (Math.ceil(num * 1.0 / 8) * 8);
    }

}
