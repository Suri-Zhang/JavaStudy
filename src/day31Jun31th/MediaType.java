package day31Jun31th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Rex Joush
 * @time 2023.02.01
 */
public class MediaType {

    public static final String Book = "book";  // 媒体类型，书籍
    public static final String Video = "video";
    // 56

    /*
     2^0 = 1
     2^1 = 2
     2^2 = 4
     2^3 = 8
     2^4 = 16
     2^5 = 32

     58 = 32 + 16 + 8 + 2
          1    1    1 0 1 0

     1749 = 1024 + 512 + 128 + 64 + 16  + 4  + 1
             1     1   0  1   1  0  1   0   1  0  1
             110 1101 0101
                6d5
     */

    /*
        1  0001
        2  0010
        3  0011
        4  0100
        5  0101
        6  0110
        7  0111
        8  1000
        9  1001
        a  1010
        b  1011
        c  1100
        d  1101
        e  1110
        f  1111
        771c
        0111 0111 0001 1100

        674(8)
        110 111 100

        0001 0010 1001 0010 1010
        1292a
     */
    /*
       2 | 56
          ----
       2  | 28   --- a
          ----
       2  | 14   --- 0
          ----
       2  |  7   --- 0
          ----
       2  |  3   --- 1
          ----
       2  |  1   --- 1
          ----
             0   --- 1
        111000
     */

    public String[] words;
    public int size = 0;
    public String[] toArray() {
        int index = 0;
        String[] newArray = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) {
                break;
            }
            newArray[index++] = words[i];
        }
        return Arrays.copyOfRange(newArray, 0, index);
    }
}
