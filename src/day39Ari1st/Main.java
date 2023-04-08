package day39Ari1st;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Rex Joush
 * @time 2023.04.01
 */
public class Main {

    public static void main(String[] args) {
//
        int h = -35;
        System.out.println(h);
        System.out.println(Integer.toBinaryString(h));
        int x = h >> 2;  // 有符号移位
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        int y = h >>> 2; // 无符号移位
        System.out.println(y);
        System.out.println(Integer.toBinaryString(y));
/*
原码，反码，补码
- 011101  -35 100011
- 0111      9   1001

35 - 9
100011
  1000
——————
101100
1
1011101  -35
   1001   9
--------
1100110

-100110
- 011001 +1
- 011010
- 26




+ 111111111111111111111111110111   ->   1073741815
11111111111111111111111111011101 // -35
11111111111111111111111111110111 // -9
00111111111111111111111111110111 // 1073741815
 */
    }
    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    // a = '0' b = '1'
    public static int hash(String s) {
        String hello = "hello";
        //              gfllo = 47
        // 7 4 10 10 16
        int hashCode = 7 + 4 * 2 + 10 * 3 + 10 * 4 + 16 * 5; // 47
        return hashCode;
    }
}
