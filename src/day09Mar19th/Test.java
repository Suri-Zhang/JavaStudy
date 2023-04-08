package day09Mar19th;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Rex Joush
 * @time 2022.03.19
 */
public class Test {


    public static void main(String[] args) {
        System.out.println((char) ('A' + 32));
    }

    // ''
    /*
        CEHabdf


        abCdEfH
        ABcDeFh



        a = CEH
        b = abdf

     */

    // String s = "hello world"
    // char[] cs = ['h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'];
    //      s[0] = h
    // int    a = 10;
    public String LowerUpper (String str) throws FileNotFoundException {
        // 'A' - 'Z'
        String a = "";
        String b = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
//            char cc = str[i];

            // 大写字母，拼接到 a 串
//          if (Character.isUpperCase('C')) {
            if (ch >= 'A' && ch <= 'Z') {
                a += ch;
            }
            // 小写字母，拼接到 b 串
            else {
                b += ch;
            }
        }
        return a+b;
    }
}
